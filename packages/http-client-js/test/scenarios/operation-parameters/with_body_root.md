# Should emit an operation that has a @bodyRoot set.

```tsp
@service
namespace Test;

model Widget {
  id: string;
  name: string;
  age?: string;
  @header foo?: string;
}

@post op create(@bodyRoot widget: Widget): void;
```

## Operation

The operation has has no required parameters so options and client should be the only ones in the signature

```ts src/api/testClientOperations.ts function create
export async function create(
  client: TestClientContext,
  widget: Widget,
  options?: CreateOptions,
): Promise<void> {
  const path = parse("/").expand({});
  const httpRequestOptions = {
    headers: {
      ...(widget.foo && { foo: widget.foo }),
    },
    body: jsonWidgetToTransportTransform(widget),
  };
  const response = await client.pathUnchecked(path).post(httpRequestOptions);

  if (typeof options?.operationOptions?.onResponse === "function") {
    options?.operationOptions?.onResponse(response);
  }
  if (+response.status === 204 && !response.body) {
    return;
  }
  throw createRestError(response);
}
```

## Options

The options bag should like all the optional parameters of the operation

```ts src/api/testClientOperations.ts interface CreateOptions
export interface CreateOptions extends OperationOptions {
  age?: string;
  foo?: string;
}
```

## Client

```ts src/testClient.ts class TestClient
export class TestClient {
  #context: TestClientContext;

  constructor(endpoint: string, options?: TestClientOptions) {
    this.#context = createTestClientContext(endpoint, options);
  }
  async create(widget: Widget, options?: CreateOptions) {
    return create(this.#context, widget, options);
  }
}
```
