export default function Book(props) {
  return (
    <table>
      <thead>
        <tr>
          <td>{props.title}</td>
          <td></td>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>ID</td>
          <td>{props.id}</td>
        </tr>
        <tr>
          <td>Author</td>
          <td>{props.author}</td>
        </tr>
        <tr>
          <td>Publisher</td>
          <td>{props.publisher}</td>
        </tr>
        <tr>
          <td>Cover Image</td>
          <td>{props.coverImage}</td>
        </tr>
        <tr>
          <td>Publish year</td>
          <td>{props.publishYear}</td>
        </tr>
        <tr>
          <td>Price</td>
          <td>{props.unitValue}</td>
        </tr>
        <tr>
          <td>Quantity</td>
          <td>{props.quantity}</td>
        </tr>
        <tr>
          <td>Max</td>
          <td>{props.max}</td>
        </tr>
      </tbody>
    </table>
  );
}