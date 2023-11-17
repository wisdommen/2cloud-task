import axios from "axios";

let base = axios.create({
  baseURL: "http://localhost:8081",
  headers: {
    "Content-Type": "application/json",
  },
})

export default {
  base
}
