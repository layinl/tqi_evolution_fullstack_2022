import Book from "../../components/book"
import ReactModal from "react-modal";
import { useEffect, useState } from "react";
import NewBook from "../../components/newBook";
import api from "../../services/api"

export default function Books(props) {
  const [isModalOpen, setModalOpen] = useState(false);
  ReactModal.setAppElement('#root');
  /* const { bookState, getBook } = useBook(); */


  const [bookState, setBookstate] = useState([{}]);

  useEffect(() => {
    api.post("inventory/books", {
      title : "Insurgent" + Math.floor(Math.random() * 1000),
      author : "Veronica Roth",
      publisher : "Rocco",
      coverImage : "img.jpg",
      publishYear : "2012",
      unitValue : 30.0,
      quantity : 50,
      max : 100
    }).then(res => console.log(res)).catch(e => console.log(e));
  }, []);

  api.get("inventory/books").then(({data}) => setBookstate(data)).catch(e => console.log(e));


  /* const book = {
    id: "1",
    title: "Divergent",
    author: "Veronica Roth",
    publisher: "Rocco",
    coverImage: "img.jpg",
    publishYear: "2012",
    unitValue: "30.0",
    quantity: "50",
    max: "100"
  } */

  return (
    <div>
      <h1>Books</h1>
        { bookState.map((book, index) => (
          <Book 
            key={index}
            id={book.id}
            title={book.title} 
            author={book.author} 
            publisher={book.publisher} 
            coverImage={book.coverImage} 
            publishYear={book.publishYear} 
            unitValue={book.unitValue} 
            quantity={book.quantity} 
            max={book.max} 
          />
        ))  }
      <button onClick={() => setModalOpen(true)}>Compra de livro</button>
      <ReactModal isOpen={isModalOpen} className="modal" overlayClassName="overlay">
        <button onClick={() => setModalOpen(false)}>Fechar</button>
        <NewBook />
      </ReactModal>
    </div>
  );
}