<template>
  <a-layout class="home">
    <a-layout-sider width="200" style="background: #fff">
        <a-menu
          v-model:openKeys="openKeys"
          mode="inline"
          :style="{ height: '100%', borderRight: 0 }"
        >
          <a-sub-menu key="sub1">
            <template #title>
              <span>
                <user-outlined />
                subnav 111111111
              </span>
            </template>
            <a-menu-item key="1">option1</a-menu-item>
            <a-menu-item key="2">option2</a-menu-item>
            <a-menu-item key="3">option3</a-menu-item>
            <a-menu-item key="4">option4</a-menu-item>
          </a-sub-menu>
          <a-sub-menu key="sub2">
            <template #title>
              <span>
                <laptop-outlined />
                subnav 2
              </span>
            </template>
            <a-menu-item key="5">option5</a-menu-item>
            <a-menu-item key="6">option6</a-menu-item>
            <a-menu-item key="7">option7</a-menu-item>
            <a-menu-item key="8">option8</a-menu-item>
          </a-sub-menu>
          <a-sub-menu key="sub3">
            <template #title>
              <span>
                <notification-outlined />
                subnav 3
              </span>
            </template>
            <a-menu-item key="9">option9</a-menu-item>
            <a-menu-item key="10">option10</a-menu-item>
            <a-menu-item key="11">option11</a-menu-item>
            <a-menu-item key="12">option12</a-menu-item>
          </a-sub-menu>
        </a-menu>
      </a-layout-sider>
    <a-layout-content
          :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
        >
      <a-list :grid="{ gutter: 16, column: 3 }" :data-source="ebooks">
        <template #renderItem="{ item }">
          <a-list-item key="item.name">
            <template #actions>
              <span v-for="{ type, text } in actions" :key="type">
                <component :is="type" style="margin-right: 8px" />
                {{ text }}
              </span>
            </template>
            <a-list-item-meta :description="item.description">
              <template #title>
                <a :href="item.href">{{ item.name }}</a>
              </template>
              <template #avatar><a-avatar :src="item.cover" /></template>
            </a-list-item-meta>
          </a-list-item>
        </template>
      </a-list>
    </a-layout-content>
  </a-layout>
</template>

<script lang="ts">
import { defineComponent, onMounted, ref, reactive, toRef } from 'vue';
import { StarOutlined, LikeOutlined, MessageOutlined } from '@ant-design/icons-vue';
import axios from 'axios';

export default defineComponent({
  name: 'HomeView',
  components: {
    StarOutlined,
    LikeOutlined,
    MessageOutlined,
  },
  setup(){
    const actions: Record<string, string>[] = [
      { type: 'StarOutlined', text: '156' },
      { type: 'LikeOutlined', text: '156' },
      { type: 'MessageOutlined', text: '2' },
    ];

    console.log("setup");
    //ref\reactive用于生成響應式的變量
    const ebooks = ref();
    const ebooks1 = reactive({
      books: []
    });

    onMounted(() => {
      console.log("onMounted1")
      axios.get(process.env.VUE_APP_SERVER + "/ebook/list?name=")
          .then((res) => {
            console.log(res)
            const data = res.data
            //给ref变量赋值的时候要用.value
            ebooks.value = data.content
            ebooks1.books = data.content
          });
    })

    //在这里return之后才能被界面拿到
    return {
      actions,
      ebooks,
      ebooks1: toRef(ebooks1, "books")
    }
  }
});
</script>

<style scoped>
  .ant-avatar {
    width: 50px;
    height: 50px;
    line-height: 50px;
    border-radius: 8%;
    margin: 5px 0;
  }
</style>
