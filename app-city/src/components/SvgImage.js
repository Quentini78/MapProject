/* eslint-disable jsx-a11y/img-redundant-alt */
import React from 'react';
import mySvg from '../resources/france-final.svg';

const SvgImage = () => {
  return (
    <div>
      <img src={mySvg} alt="My SVG Image" />
    </div>
  );
};

export default SvgImage;