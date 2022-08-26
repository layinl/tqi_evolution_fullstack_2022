import Client from "../../components/client"


export default function Clients(props) {
  const client = {
    id: "1",
    name: "Layin",
    age: "21",
    gender: "Male",
    address: "PQP"
  }
  return (
    <div>
      <h1>Clients</h1>
      <Client 
        
        id={client.id}
        name={client.name}
        age={client.age}
        gender={client.gender}
        address={client.address}
      />
    </div>
  );
}