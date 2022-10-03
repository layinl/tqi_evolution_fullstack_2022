import { useState } from "react";
import Client from "../../components/client"
import api from "../../services/api";


export default function Clients(props) {
  const [clients, setClients] = useState([]);

api.get("clients").then(({ data }) => setClients(data)).catch(e => console.log(e));

  return (
    <div>
      <h1>Clients</h1>
      {clients.map((client, index) => (<Client
        key={index}
        id={client.id}
        name={client.name}
        age={client.age}
        gender={client.gender}
        address={client.address}
      />
      ))}
    </div>
  );
}