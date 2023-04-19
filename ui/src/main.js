import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

import './assets/main.css'

import auth from './js/auth'

//const app = createApp(App);

initGlobals();

auth.init(
  () => {
    initApp();
    //window.appEvents.on("app::logout", auth.logout.bind(auth));
  },
  (err) => {
    console.error("Application initialization error");
    console.error(err);
  }
);

//initApp();

function initGlobals() {
  let baseUrl = getBaseUrl();
  console.log("Checkpoint 2 :: Base URL = "+baseUrl);
  window.appBaseUrl = baseUrl;
  //window.appApiUrl = baseUrl + "/api";
  window.appApiUrl = "http://localhost:8373/api";
  //window.appApiUrl = baseUrl;
  window.appApiVersion = "v1";
  window.appConfig = {};
  window.appAuth = {};
  console.log("Checkpoint 3");

  window.appEvents = {
    _vue: createApp(App),
    _isError: false,
    _eventNames: [],

    emit: function(evt, payload) {
      if (this._isError) {
        this.resetError();
      }
      this._vue.$emit(evt, payload);
    },

    on: function(evt, callback) {
      this._vue.$on(evt, callback);
      this._eventNames.push(evt);
    },

    setErrorFlag() {
      this._isError = true;
    },

    resetError() {
      this._vue.$emit(events.ERROR_RESET);
      this._isError = false;
    },

    clear() {
      let eventNames = this._eventNames;

      eventNames.forEach(evt => {
        this._vue.$off(evt);
      });

      eventNames.splice(0, eventNames.length);
    }
  };

  console.log("Checkpoint 4")
}

function getBaseUrl() {
  let portSuffix = window.location.port ? `:${window.location.port}` : "";
  return window.location.protocol + "//" + window.location.hostname + portSuffix;
}

function initApp() {
  const app = createApp(App);
  app.use(router)
  app.mount('#app')
}
