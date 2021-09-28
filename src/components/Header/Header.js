import Link from 'next/link';
import React from 'react';
import { AiFillGithub, AiFillInstagram, AiFillLinkedin } from 'react-icons/ai';
import { FiHome } from 'react-icons/fi';

import { Container, Div1, Div2, Div3, NavLink, SocialIcons } from './HeaderStyles';

const Header = () =>  (
  <Container>
    <Div1>
      <Link href="https://eddieatjollyroger.github.io/my-webpage">
        <a style={{ display: 'flex', alignItems: 'center', color:"white", textDecoration:"none" }}>
          <FiHome size="5rem" /> <span> Home</span>
        </a>
      </Link>
    </Div1>
    <Div2>
      <li>
        <Link href="https://eddieatjollyroger.github.io/my-webpage/#projects">
        <NavLink><a style = {{color:"white", textDecoration:"none"}} href="https://eddieatjollyroger.github.io/my-webpage/#projects">Projects</a></NavLink>
        </Link>
      </li>
      <li>
        <Link href="https://eddieatjollyroger.github.io/my-webpage/#tech">
        <NavLink><a style = {{color:"white", textDecoration:"none"}} href="https://eddieatjollyroger.github.io/my-webpage/#tech">Technologies</a></NavLink>
        </Link>
      </li>        
      <li>
        <Link href="https://eddieatjollyroger.github.io/my-webpage/#about">
        <NavLink><a style = {{color:"white", textDecoration:"none"}} href="https://eddieatjollyroger.github.io/my-webpage/#about">About</a></NavLink>
        </Link>
      </li>  
      <li>
      <Link href="https://eddieatjollyroger.github.io/my-webpage/#curriculum">
          <NavLink><a style = {{color:"white", textDecoration:"none"}} href="https://eddieatjollyroger.github.io/my-webpage/#curriculum">CV</a></NavLink>
        </Link>  
        </li>
    </Div2>
      <Div3>
        <SocialIcons href="https://github.com/eddieatjollyroger">
          <AiFillGithub size="3rem" />
        </SocialIcons>
        <SocialIcons href="https://linkedin.com/in/joaocodesurfer">
          <AiFillLinkedin size="3rem" />
        </SocialIcons>
      </Div3>
    </Container>
);

export default Header;
