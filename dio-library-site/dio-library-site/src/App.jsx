import * as Styled from './global/App.style.jsx';
import { Link, Outlet } from 'react-router-dom';

function App() {
  return (
    <Styled.Wrapper>
      <Styled.Main>
        <Styled.Nav>
          <ul>
            <li><Link to="/">Home</Link></li>
            <li><Link to="books">Books</Link></li>
            <li><Link to="clients">Clients</Link></li>
            <li><Link to="sale">Sale</Link></li>
          </ul>
        </Styled.Nav>
      <Styled.ContentWrapper>
        <Outlet />
      </Styled.ContentWrapper>
      </Styled.Main>
    </Styled.Wrapper>
  );
}

export default App;
