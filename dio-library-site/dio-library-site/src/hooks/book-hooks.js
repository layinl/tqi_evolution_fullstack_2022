import { useContext } from "react"
import { BookContext } from "../providers/book-provider"


const useBook = () => {
  const { bookState, getBook } = useContext(BookContext);
  return { bookState, getBook };
}

export default useBook;