
import axios from "axios";
import { Login } from "./pages/types";

const API_URL = "http://localhost:8080";

export function fetchLogin() {
    return axios(`${API_URL}/auth/login`)
}

export function loginUser(login: Login) {
    console.log(login.login, login.senha)
    return axios.post(`${API_URL}/auth/login`, login);
}

// Verifique e acesse a variável de ambiente
//const apiBaseUrl =
//  typeof window._env_ === "object" && window._env_ !== null
//    ? (window._env_ as { [key: string]: string }).REACT_APP_API_BASE ||
//      "http://localhost:3000/"
//    : "http://localhost:3000/";

// Configuração do Axios
//const api = axios.create({
//  baseURL: apiBaseUrl,
//  headers: {
//    "Content-Type": "application/json",
//  },
//});

//export default api;

//export function saveOrder(payload: OrderPayLoad){
//   return axios.post(`${API_URL}/orders`, payload);
//}