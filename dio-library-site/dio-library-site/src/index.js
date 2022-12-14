import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import './global/globals.css';
import App from './App';
import Books from './pages/books';
import Clients from './pages/clients';
import Sale from './pages/sale';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <Routes>
      <Route path='/' element={<App />}>
        <Route path='books' element={<Books />}>Books</Route>
        <Route path='clients' element={<Clients />}>Books</Route>
        <Route path='sale' element={<Sale />}>Books</Route>
      </Route>
    </Routes>
  </BrowserRouter>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
