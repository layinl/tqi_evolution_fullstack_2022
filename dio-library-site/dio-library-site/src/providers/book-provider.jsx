import { createContext, useCallback, useState } from "react";
import api from "../services/api";

export const BookContext = createContext();

const BookProvider = ({ children }) => {
  const [bookState, setBookState] = useState([{}]);

  const getBook = () => {
    api
      .get(`inventory/books`)
      .then(({ data }) => {
        console.log(JSON.stringify(data));
        setBookState(() => (/* {
            id: data.id,
            title: data.title,
            author: data.author,
            publisher: data.publisher,
            coverImage: data.coverImage,
            publishYear: data.publishYear,
            unitValue: data.unitValue,
            quantity: data.quantity,
            max: data.max
          } */
          data
        ));
      })
  }

  const contextValue = {
    bookState: bookState,
    getBook: useCallback(() => getBook(), [])
  };

  return (
    <BookContext.Provider value={contextValue}>
      {children}
    </BookContext.Provider>
  )

};

export default BookProvider;