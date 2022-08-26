import styled from "styled-components"

export const Wrapper = styled.div`
  background-color: #121212;
  min-height: 100vh;
  display: flex;
  justify-content: center;
`

export const Main = styled.div`
  background-color: #1f272f;
  width: 800px;
  max-width: 95vw;
  min-height: 600px;
  margin: 20px;
  border-radius: 12px;
  font-size: calc(10px + 2vmin);
  color: whitesmoke;
`

export const Nav = styled.nav`
  ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    height: 4rem;
    width: 100%;
    border-radius: 12px 12px 0 0;
    
    background-color: #005f9f;
  }
  li {
    float: left;
  }

  li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
  }
`

export const ContentWrapper = styled.div`
  display: flex;
  justify-content: center;
`