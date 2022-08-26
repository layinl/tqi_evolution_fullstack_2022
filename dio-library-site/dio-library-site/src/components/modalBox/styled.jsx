import styled from "styled-components"

export const Modal = styled.div`
  display: none;
  position: fixed;
  z-index: 1;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: #000;
  background-color: #00000010;
`

export const Content = styled.div`
  margin: 15% auto;
  padding: 20px;
  width: 80%;
`