<script setup lang="ts">
import MenuOptionItem from './SettingItem.vue'
</script>

<template>

<div class="title-div">

  <h2 class="title-text">Settings</h2>

</div>

  <MenuOptionItem>
    <template #heading>Option 1</template>
  </MenuOptionItem>

  <MenuOptionItem>
    <template #heading>Option 2</template>
  </MenuOptionItem>

  <MenuOptionItem>
    <template #heading>Option 3</template>
  </MenuOptionItem>

  <MenuOptionItem>
    <template #heading>Option 4</template>
  </MenuOptionItem>
</template>

<style scoped>

.title-div {
  text-align: center;
  background-color: #CCCCCC;
}

.title-text {
  font-size: 3rem;
  font-weight: 600;
  margin-bottom: 0.4rem;
  color: var(--color-heading);
}

</style>