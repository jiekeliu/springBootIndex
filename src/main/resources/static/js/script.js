// console.clear();

currentIndex = 0;

slides = [
{
  title: "欢迎来到我的世界",
  url: "http://www.baidu.com",
  subtitle: "我是Jesonker",
  description: "Adventure is never far away",
  image: "img/1.jpg" },

{
  title: "Chamonix",
  url: "http://www.baidu.com",
  subtitle: "France",
  description: "Let your dreams come true",
  image: "img/2.jpg" },

{
  title: "Mimisa Rocks",
  url: "http://www.baidu.com",
  subtitle: "Australia",
  description: "A piece of heaven",
  image: "img/3.jpg" },
  ];

$.ajax({
  url:"http://47.98.116.55:9600/mate?page=1&limit=30&sort=false",
  success:function(result){
    let items = [];
    for(i = 0,len=result.data.length; i < len; i++) {
      let information = {
        title: result.data[i].title,
        subtitle: result.data[i].subtitle,
        description: result.data[i].description,
        image:result.data[i].image,
        url:result.data[i].url
      }
      items.push(information)
    }
    slides = items;
  }});



function useTilt(active) {
  const ref = React.useRef(null);

  React.useEffect(() => {
    if (!ref.current || !active) {
      return;
    }

    const state = {
      rect: undefined,
      mouseX: undefined,
      mouseY: undefined };


    let el = ref.current;

    const handleMouseMove = e => {
      if (!el) {
        return;
      }
      if (!state.rect) {
        state.rect = el.getBoundingClientRect();
      }
      state.mouseX = e.clientX;
      state.mouseY = e.clientY;
      const px = (state.mouseX - state.rect.left) / state.rect.width;
      const py = (state.mouseY - state.rect.top) / state.rect.height;

      el.style.setProperty("--px", px);
      el.style.setProperty("--py", py);
    };

    el.addEventListener("mousemove", handleMouseMove);

    return () => {
      el.removeEventListener("mousemove", handleMouseMove);
    };
  }, [active]);

  return ref;
}

const initialState = {
  slideIndex: 0 };


const slidesReducer = (state, event) => {
  if (event.type === "NEXT") {
    currentIndex = state.slideIndex;
    return {
      ...state,
      slideIndex: (state.slideIndex + 1) % slides.length };

  }
  if (event.type === "PREV") {
    currentIndex = state.slideIndex;
    return {
      ...state,
      slideIndex:
      state.slideIndex === 0 ? slides.length - 1 : state.slideIndex - 1 };

  }
};

function Slide({ slide, offset }) {
  const active = offset === 0 ? true : null;
  const ref = useTilt(active);

  return (
    React.createElement("div", {
      onClick: () => {changeUrl();},
      ref: ref,
      className: "slide",
      "data-active": active,
      style: {
        "--offset": offset,
        "--dir": offset === 0 ? 0 : offset > 0 ? 1 : -1 } },


    React.createElement("div", {
      className: "slideBackground",
      style: {
        backgroundImage: `url('${slide.image}')` } }),


    React.createElement("div", {
      className: "slideContent",
      style: {
        backgroundImage: `url('${slide.image}')` } },


    React.createElement("div", { className: "slideContentInner" },
    React.createElement("h2", { className: "slideTitle" }, slide.title),
    React.createElement("h3", { className: "slideSubtitle" }, slide.subtitle),
    React.createElement("p", { className: "slideDescription" }, slide.description)))));




}

function App() {
  const [state, dispatch] = React.useReducer(slidesReducer, initialState);
  return (
    React.createElement("div", { className: "slides" },
    React.createElement("button", { onClick: () => dispatch({ type: "PREV" }) }, "\u2039"),

    [...slides, ...slides, ...slides].map((slide, i) => {
      let offset = slides.length + (state.slideIndex - i);
      return React.createElement(Slide, { slide: slide, offset: offset, key: i });
    }),
    React.createElement("button", { onClick: () => dispatch({ type: "NEXT" }) }, "\u203A")));


}


function changeUrl(){
 // console.log(slides);
 // console.log(currentIndex);
 // console.log(slides[currentIndex].url);
  window.location.href=slides[currentIndex].url;
}


const elApp = document.getElementById("app");
ReactDOM.render(React.createElement(App, null), elApp);


