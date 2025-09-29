export async function getServerSideProps() {
  const res = await fetch("https://jsonplaceholder.typicode.com/posts");
  const posts = await res.json();

  return {
    props: {
      posts: posts.slice(0, 10),
    },
  };
}

export default function AppSSR({ posts }) {
  return (
    <div>
      <h1>게시글 목록 (SSR with Mock API)</h1>
      <ul>
        {posts.map((post) => (
          <li key={post.id}>
            <strong>{post.title}</strong>
            <br />
            {post.body}
          </li>
        ))}
      </ul>
    </div>
  );
}
