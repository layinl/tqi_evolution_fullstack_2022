export default function NewBook(props) {

  return (
    <table>
      <tbody>
        <tr>
          <td><label htmlFor="title">Title</label></td>
          <td><input type="text" name="title" id="title" placeholder="Title" /></td>
        </tr>
        <tr>
          <td><label htmlFor="author">Author</label></td>
          <td><input type="text" name="author" id="author" placeholder="Author" /></td>
        </tr>
        <tr>
          <td><label htmlFor="publisher">Publisher</label></td>
          <td><input type="text" name="publisher" id="publisher" placeholder="Publisher" /></td>
        </tr>
        <tr>
          <td><label htmlFor="coverImage">Cover Image</label></td>
          <td><input type="text" name="coverImage" id="coverImage" placeholder="Cover Image" /></td>
        </tr>
        <tr>
          <td><label htmlFor="publishYear">Publish year</label></td>
          <td><input type="text" name="publishYear" id="publishYear" placeholder="Publish Year" /></td>
        </tr>
        <tr>
          <td><label htmlFor="price">Price</label></td>
          <td><input type="text" name="price" id="price" placeholder="Price" /></td>
        </tr>
        <tr>
          <td><label htmlFor="quantity">Quantity</label></td>
          <td><input type="text" name="quantity" id="quantity" placeholder="Quantity" /></td>
        </tr>
        <tr>
          <td><label htmlFor="max">Max</label></td>
          <td><input type="text" name="max" id="max" placeholder="Max" /></td>
        </tr>
      </tbody>
    </table>
  );
}