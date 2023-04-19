<template>
    <div class="item">
      <i>
        <slot name="icon"></slot>
      </i>
      <div class="menu-option">
        <h2>
          <slot name="heading"></slot>
        </h2>
        <slot></slot>
      </div>
    </div>
  </template>
  
  <style scoped>
  .item {
    margin-top: 2rem;
    display: flex;
  }
  
  .menu-option {
    flex: 1;
    text-align: center;
  }
  
  
  h2 {
    font-size: 2rem;
    font-weight: 500;
    margin-bottom: 0.4rem;
    color: var(--color-heading);
  }

  h2:hover {
    color: gray;
    /* border: 1px solid #000000 */
  }
  </style>
  