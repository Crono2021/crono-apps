.class public final Lcoil/RealImageLoader;
.super Ljava/lang/Object;
.source "RealImageLoader.kt"

# interfaces
.implements Lcoil/ImageLoader;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcoil/RealImageLoader$Companion;
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nRealImageLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealImageLoader.kt\ncoil/RealImageLoader\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n+ 3 ComponentRegistry.kt\ncoil/ComponentRegistry$Builder\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Utils.kt\ncoil/util/-Utils\n+ 6 Bitmaps.kt\ncoil/util/-Bitmaps\n+ 7 BitmapDrawable.kt\nandroidx/core/graphics/drawable/BitmapDrawableKt\n+ 8 Logs.kt\ncoil/util/-Logs\n*L\n1#1,296:1\n274#1,15:326\n274#1,15:345\n48#2,4:297\n138#3:301\n138#3:302\n138#3:303\n138#3:304\n138#3:305\n138#3:306\n146#3:307\n146#3:308\n154#3:309\n154#3:310\n154#3:311\n154#3:312\n154#3:313\n154#3:314\n154#3:315\n154#3:316\n1#4:317\n1#4:319\n173#5:318\n50#6:320\n28#7:321\n21#8,4:322\n21#8,4:341\n21#8,4:360\n*S KotlinDebug\n*F\n+ 1 RealImageLoader.kt\ncoil/RealImageLoader\n*L\n241#1:326,15\n255#1:345,15\n78#1:297,4\n85#1:301\n86#1:302\n87#1:303\n88#1:304\n89#1:305\n90#1:306\n92#1:307\n93#1:308\n95#1:309\n96#1:310\n97#1:311\n98#1:312\n99#1:313\n100#1:314\n101#1:315\n102#1:316\n170#1:319\n170#1:318\n171#1:320\n171#1:321\n238#1:322,4\n252#1:341,4\n261#1:360,4\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000 [2\u00020\u0001:\u0001[Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u0012\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016J\u0019\u0010@\u001a\u00020A2\u0006\u0010>\u001a\u00020?H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010BJ!\u0010C\u001a\u00020A2\u0006\u0010D\u001a\u00020?2\u0006\u0010E\u001a\u00020FH\u0083@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010GJ\u0008\u0010H\u001a\u00020IH\u0016J\u0018\u0010J\u001a\u00020K2\u0006\u0010>\u001a\u00020?2\u0006\u0010L\u001a\u00020MH\u0002J\"\u0010N\u001a\u00020K2\u0006\u0010O\u001a\u00020P2\u0008\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010L\u001a\u00020MH\u0002J\"\u0010S\u001a\u00020K2\u0006\u0010O\u001a\u00020T2\u0008\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010L\u001a\u00020MH\u0002J\u0015\u0010U\u001a\u00020K2\u0006\u0010V\u001a\u00020FH\u0000\u00a2\u0006\u0002\u0008WJ\u0008\u00108\u001a\u00020KH\u0016J1\u0010X\u001a\u00020K2\u0006\u0010O\u001a\u00020A2\u0008\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010L\u001a\u00020M2\u000c\u0010Y\u001a\u0008\u0012\u0004\u0012\u00020K0ZH\u0082\u0008R\u0017\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u0007\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u0010X\u0096\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u001d\u0010 \u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002\u00a2\u0006\u000c\u001a\u0004\u0008#\u0010$*\u0004\u0008!\u0010\"R\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010\'R\u0014\u0010(\u001a\u0008\u0012\u0004\u0012\u00020*0)X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010,R\u001d\u0010-\u001a\u0004\u0018\u00010\u00088VX\u0096\u0084\u0002\u00a2\u0006\u000c\u001a\u0004\u0008/\u00100*\u0004\u0008.\u0010\"R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0007\u00a2\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\u0008\n\u0000\u001a\u0004\u00082\u00103R\u000e\u00104\u001a\u000205X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019\u00a8\u0006\\"
    }
    d2 = {
        "Lcoil/RealImageLoader;",
        "Lcoil/ImageLoader;",
        "context",
        "Landroid/content/Context;",
        "defaults",
        "Lcoil/request/DefaultRequestOptions;",
        "memoryCacheLazy",
        "Lkotlin/Lazy;",
        "Lcoil/memory/MemoryCache;",
        "diskCacheLazy",
        "Lcoil/disk/DiskCache;",
        "callFactoryLazy",
        "Lokhttp3/Call$Factory;",
        "eventListenerFactory",
        "Lcoil/EventListener$Factory;",
        "componentRegistry",
        "Lcoil/ComponentRegistry;",
        "options",
        "Lcoil/util/ImageLoaderOptions;",
        "logger",
        "Lcoil/util/Logger;",
        "(Landroid/content/Context;Lcoil/request/DefaultRequestOptions;Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil/EventListener$Factory;Lcoil/ComponentRegistry;Lcoil/util/ImageLoaderOptions;Lcoil/util/Logger;)V",
        "getCallFactoryLazy",
        "()Lkotlin/Lazy;",
        "getComponentRegistry",
        "()Lcoil/ComponentRegistry;",
        "components",
        "getComponents",
        "getContext",
        "()Landroid/content/Context;",
        "getDefaults",
        "()Lcoil/request/DefaultRequestOptions;",
        "diskCache",
        "getDiskCache$delegate",
        "(Lcoil/RealImageLoader;)Ljava/lang/Object;",
        "getDiskCache",
        "()Lcoil/disk/DiskCache;",
        "getDiskCacheLazy",
        "getEventListenerFactory",
        "()Lcoil/EventListener$Factory;",
        "interceptors",
        "",
        "Lcoil/intercept/Interceptor;",
        "getLogger",
        "()Lcoil/util/Logger;",
        "memoryCache",
        "getMemoryCache$delegate",
        "getMemoryCache",
        "()Lcoil/memory/MemoryCache;",
        "getMemoryCacheLazy",
        "getOptions",
        "()Lcoil/util/ImageLoaderOptions;",
        "requestService",
        "Lcoil/request/RequestService;",
        "scope",
        "Lkotlinx/coroutines/CoroutineScope;",
        "shutdown",
        "Ljava/util/concurrent/atomic/AtomicBoolean;",
        "systemCallbacks",
        "Lcoil/util/SystemCallbacks;",
        "enqueue",
        "Lcoil/request/Disposable;",
        "request",
        "Lcoil/request/ImageRequest;",
        "execute",
        "Lcoil/request/ImageResult;",
        "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;",
        "executeMain",
        "initialRequest",
        "type",
        "",
        "(Lcoil/request/ImageRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;",
        "newBuilder",
        "Lcoil/ImageLoader$Builder;",
        "onCancel",
        "",
        "eventListener",
        "Lcoil/EventListener;",
        "onError",
        "result",
        "Lcoil/request/ErrorResult;",
        "target",
        "Lcoil/target/Target;",
        "onSuccess",
        "Lcoil/request/SuccessResult;",
        "onTrimMemory",
        "level",
        "onTrimMemory$coil_base_release",
        "transition",
        "setDrawable",
        "Lkotlin/Function0;",
        "Companion",
        "coil-base_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x9,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field public static final Companion:Lcoil/RealImageLoader$Companion;

.field private static final REQUEST_TYPE_ENQUEUE:I = 0x0

.field private static final REQUEST_TYPE_EXECUTE:I = 0x1

.field private static final TAG:Ljava/lang/String; = "RealImageLoader"


# instance fields
.field private final callFactoryLazy:Lkotlin/Lazy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lkotlin/Lazy<",
            "Lokhttp3/Call$Factory;",
            ">;"
        }
    .end annotation
.end field

.field private final componentRegistry:Lcoil/ComponentRegistry;

.field private final components:Lcoil/ComponentRegistry;

.field private final context:Landroid/content/Context;

.field private final defaults:Lcoil/request/DefaultRequestOptions;

.field private final diskCacheLazy:Lkotlin/Lazy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lkotlin/Lazy<",
            "Lcoil/disk/DiskCache;",
            ">;"
        }
    .end annotation
.end field

.field private final eventListenerFactory:Lcoil/EventListener$Factory;

.field private final interceptors:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lcoil/intercept/Interceptor;",
            ">;"
        }
    .end annotation
.end field

.field private final logger:Lcoil/util/Logger;

.field private final memoryCacheLazy:Lkotlin/Lazy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lkotlin/Lazy<",
            "Lcoil/memory/MemoryCache;",
            ">;"
        }
    .end annotation
.end field

.field private final options:Lcoil/util/ImageLoaderOptions;

.field private final requestService:Lcoil/request/RequestService;

.field private final scope:Lkotlinx/coroutines/CoroutineScope;

.field private final shutdown:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private final systemCallbacks:Lcoil/util/SystemCallbacks;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lcoil/RealImageLoader$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcoil/RealImageLoader$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lcoil/RealImageLoader;->Companion:Lcoil/RealImageLoader$Companion;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcoil/request/DefaultRequestOptions;Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil/EventListener$Factory;Lcoil/ComponentRegistry;Lcoil/util/ImageLoaderOptions;Lcoil/util/Logger;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "defaults"    # Lcoil/request/DefaultRequestOptions;
    .param p3, "memoryCacheLazy"    # Lkotlin/Lazy;
    .param p4, "diskCacheLazy"    # Lkotlin/Lazy;
    .param p5, "callFactoryLazy"    # Lkotlin/Lazy;
    .param p6, "eventListenerFactory"    # Lcoil/EventListener$Factory;
    .param p7, "componentRegistry"    # Lcoil/ComponentRegistry;
    .param p8, "options"    # Lcoil/util/ImageLoaderOptions;
    .param p9, "logger"    # Lcoil/util/Logger;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcoil/request/DefaultRequestOptions;",
            "Lkotlin/Lazy<",
            "+",
            "Lcoil/memory/MemoryCache;",
            ">;",
            "Lkotlin/Lazy<",
            "+",
            "Lcoil/disk/DiskCache;",
            ">;",
            "Lkotlin/Lazy<",
            "+",
            "Lokhttp3/Call$Factory;",
            ">;",
            "Lcoil/EventListener$Factory;",
            "Lcoil/ComponentRegistry;",
            "Lcoil/util/ImageLoaderOptions;",
            "Lcoil/util/Logger;",
            ")V"
        }
    .end annotation

    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    iput-object p1, p0, Lcoil/RealImageLoader;->context:Landroid/content/Context;

    .line 67
    iput-object p2, p0, Lcoil/RealImageLoader;->defaults:Lcoil/request/DefaultRequestOptions;

    .line 68
    iput-object p3, p0, Lcoil/RealImageLoader;->memoryCacheLazy:Lkotlin/Lazy;

    .line 69
    iput-object p4, p0, Lcoil/RealImageLoader;->diskCacheLazy:Lkotlin/Lazy;

    .line 70
    iput-object p5, p0, Lcoil/RealImageLoader;->callFactoryLazy:Lkotlin/Lazy;

    .line 71
    iput-object p6, p0, Lcoil/RealImageLoader;->eventListenerFactory:Lcoil/EventListener$Factory;

    .line 72
    iput-object p7, p0, Lcoil/RealImageLoader;->componentRegistry:Lcoil/ComponentRegistry;

    .line 73
    iput-object p8, p0, Lcoil/RealImageLoader;->options:Lcoil/util/ImageLoaderOptions;

    .line 74
    iput-object p9, p0, Lcoil/RealImageLoader;->logger:Lcoil/util/Logger;

    .line 77
    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-static {v0, v1, v0}, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job;ILjava/lang/Object;)Lkotlinx/coroutines/CompletableJob;

    move-result-object v0

    invoke-static {}, Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;

    move-result-object v1

    invoke-virtual {v1}, Lkotlinx/coroutines/MainCoroutineDispatcher;->getImmediate()Lkotlinx/coroutines/MainCoroutineDispatcher;

    move-result-object v1

    check-cast v1, Lkotlin/coroutines/CoroutineContext;

    invoke-interface {v0, v1}, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;

    move-result-object v0

    .line 78
    const/4 v1, 0x0

    .line 297
    .local v1, "$i$f$CoroutineExceptionHandler":I
    sget-object v2, Lkotlinx/coroutines/CoroutineExceptionHandler;->Key:Lkotlinx/coroutines/CoroutineExceptionHandler$Key;

    new-instance v3, Lcoil/RealImageLoader$special$$inlined$CoroutineExceptionHandler$1;

    invoke-direct {v3, v2, p0}, Lcoil/RealImageLoader$special$$inlined$CoroutineExceptionHandler$1;-><init>(Lkotlinx/coroutines/CoroutineExceptionHandler$Key;Lcoil/RealImageLoader;)V

    check-cast v3, Lkotlinx/coroutines/CoroutineExceptionHandler;

    .line 300
    nop

    .end local v1    # "$i$f$CoroutineExceptionHandler":I
    check-cast v3, Lkotlin/coroutines/CoroutineContext;

    .line 77
    invoke-interface {v0, v3}, Lkotlin/coroutines/CoroutineContext;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;

    move-result-object v0

    invoke-static {v0}, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;

    move-result-object v0

    iput-object v0, p0, Lcoil/RealImageLoader;->scope:Lkotlinx/coroutines/CoroutineScope;

    .line 79
    new-instance v0, Lcoil/util/SystemCallbacks;

    invoke-virtual {p8}, Lcoil/util/ImageLoaderOptions;->getNetworkObserverEnabled()Z

    move-result v1

    invoke-direct {v0, p0, p1, v1}, Lcoil/util/SystemCallbacks;-><init>(Lcoil/RealImageLoader;Landroid/content/Context;Z)V

    iput-object v0, p0, Lcoil/RealImageLoader;->systemCallbacks:Lcoil/util/SystemCallbacks;

    .line 80
    new-instance v1, Lcoil/request/RequestService;

    move-object v2, p0

    check-cast v2, Lcoil/ImageLoader;

    invoke-direct {v1, v2, v0, p9}, Lcoil/request/RequestService;-><init>(Lcoil/ImageLoader;Lcoil/util/SystemCallbacks;Lcoil/util/Logger;)V

    iput-object v1, p0, Lcoil/RealImageLoader;->requestService:Lcoil/request/RequestService;

    .line 81
    nop

    .line 82
    nop

    .line 105
    nop

    .line 83
    invoke-virtual {p7}, Lcoil/ComponentRegistry;->newBuilder()Lcoil/ComponentRegistry$Builder;

    move-result-object v2

    .line 85
    new-instance v3, Lcoil/map/HttpUrlMapper;

    invoke-direct {v3}, Lcoil/map/HttpUrlMapper;-><init>()V

    check-cast v3, Lcoil/map/Mapper;

    .local v2, "this_$iv":Lcoil/ComponentRegistry$Builder;
    .local v3, "mapper$iv":Lcoil/map/Mapper;
    const/4 v4, 0x0

    .line 301
    .local v4, "$i$f$add":I
    const-class v5, Lokhttp3/HttpUrl;

    invoke-virtual {v2, v3, v5}, Lcoil/ComponentRegistry$Builder;->add(Lcoil/map/Mapper;Ljava/lang/Class;)Lcoil/ComponentRegistry$Builder;

    move-result-object v2

    .line 86
    .end local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .end local v3    # "mapper$iv":Lcoil/map/Mapper;
    .end local v4    # "$i$f$add":I
    new-instance v3, Lcoil/map/StringMapper;

    invoke-direct {v3}, Lcoil/map/StringMapper;-><init>()V

    check-cast v3, Lcoil/map/Mapper;

    .restart local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .restart local v3    # "mapper$iv":Lcoil/map/Mapper;
    const/4 v4, 0x0

    .line 302
    .restart local v4    # "$i$f$add":I
    const-class v5, Ljava/lang/String;

    invoke-virtual {v2, v3, v5}, Lcoil/ComponentRegistry$Builder;->add(Lcoil/map/Mapper;Ljava/lang/Class;)Lcoil/ComponentRegistry$Builder;

    move-result-object v2

    .line 87
    .end local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .end local v3    # "mapper$iv":Lcoil/map/Mapper;
    .end local v4    # "$i$f$add":I
    new-instance v3, Lcoil/map/FileUriMapper;

    invoke-direct {v3}, Lcoil/map/FileUriMapper;-><init>()V

    check-cast v3, Lcoil/map/Mapper;

    .restart local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .restart local v3    # "mapper$iv":Lcoil/map/Mapper;
    const/4 v4, 0x0

    .line 303
    .restart local v4    # "$i$f$add":I
    const-class v5, Landroid/net/Uri;

    invoke-virtual {v2, v3, v5}, Lcoil/ComponentRegistry$Builder;->add(Lcoil/map/Mapper;Ljava/lang/Class;)Lcoil/ComponentRegistry$Builder;

    move-result-object v2

    .line 88
    .end local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .end local v3    # "mapper$iv":Lcoil/map/Mapper;
    .end local v4    # "$i$f$add":I
    new-instance v3, Lcoil/map/ResourceUriMapper;

    invoke-direct {v3}, Lcoil/map/ResourceUriMapper;-><init>()V

    check-cast v3, Lcoil/map/Mapper;

    .restart local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .restart local v3    # "mapper$iv":Lcoil/map/Mapper;
    const/4 v4, 0x0

    .line 304
    .restart local v4    # "$i$f$add":I
    const-class v5, Landroid/net/Uri;

    invoke-virtual {v2, v3, v5}, Lcoil/ComponentRegistry$Builder;->add(Lcoil/map/Mapper;Ljava/lang/Class;)Lcoil/ComponentRegistry$Builder;

    move-result-object v2

    .line 89
    .end local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .end local v3    # "mapper$iv":Lcoil/map/Mapper;
    .end local v4    # "$i$f$add":I
    new-instance v3, Lcoil/map/ResourceIntMapper;

    invoke-direct {v3}, Lcoil/map/ResourceIntMapper;-><init>()V

    check-cast v3, Lcoil/map/Mapper;

    .restart local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .restart local v3    # "mapper$iv":Lcoil/map/Mapper;
    const/4 v4, 0x0

    .line 305
    .restart local v4    # "$i$f$add":I
    const-class v5, Ljava/lang/Integer;

    invoke-virtual {v2, v3, v5}, Lcoil/ComponentRegistry$Builder;->add(Lcoil/map/Mapper;Ljava/lang/Class;)Lcoil/ComponentRegistry$Builder;

    move-result-object v2

    .line 90
    .end local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .end local v3    # "mapper$iv":Lcoil/map/Mapper;
    .end local v4    # "$i$f$add":I
    new-instance v3, Lcoil/map/ByteArrayMapper;

    invoke-direct {v3}, Lcoil/map/ByteArrayMapper;-><init>()V

    check-cast v3, Lcoil/map/Mapper;

    .restart local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .restart local v3    # "mapper$iv":Lcoil/map/Mapper;
    const/4 v4, 0x0

    .line 306
    .restart local v4    # "$i$f$add":I
    const-class v5, [B

    invoke-virtual {v2, v3, v5}, Lcoil/ComponentRegistry$Builder;->add(Lcoil/map/Mapper;Ljava/lang/Class;)Lcoil/ComponentRegistry$Builder;

    move-result-object v2

    .line 92
    .end local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .end local v3    # "mapper$iv":Lcoil/map/Mapper;
    .end local v4    # "$i$f$add":I
    new-instance v3, Lcoil/key/UriKeyer;

    invoke-direct {v3}, Lcoil/key/UriKeyer;-><init>()V

    check-cast v3, Lcoil/key/Keyer;

    .restart local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .local v3, "keyer$iv":Lcoil/key/Keyer;
    const/4 v4, 0x0

    .line 307
    .restart local v4    # "$i$f$add":I
    const-class v5, Landroid/net/Uri;

    invoke-virtual {v2, v3, v5}, Lcoil/ComponentRegistry$Builder;->add(Lcoil/key/Keyer;Ljava/lang/Class;)Lcoil/ComponentRegistry$Builder;

    move-result-object v2

    .line 93
    .end local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .end local v3    # "keyer$iv":Lcoil/key/Keyer;
    .end local v4    # "$i$f$add":I
    new-instance v3, Lcoil/key/FileKeyer;

    invoke-virtual {p8}, Lcoil/util/ImageLoaderOptions;->getAddLastModifiedToFileCacheKey()Z

    move-result v4

    invoke-direct {v3, v4}, Lcoil/key/FileKeyer;-><init>(Z)V

    check-cast v3, Lcoil/key/Keyer;

    .restart local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .restart local v3    # "keyer$iv":Lcoil/key/Keyer;
    const/4 v4, 0x0

    .line 308
    .restart local v4    # "$i$f$add":I
    const-class v5, Ljava/io/File;

    invoke-virtual {v2, v3, v5}, Lcoil/ComponentRegistry$Builder;->add(Lcoil/key/Keyer;Ljava/lang/Class;)Lcoil/ComponentRegistry$Builder;

    move-result-object v2

    .line 95
    .end local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .end local v3    # "keyer$iv":Lcoil/key/Keyer;
    .end local v4    # "$i$f$add":I
    new-instance v3, Lcoil/fetch/HttpUriFetcher$Factory;

    invoke-virtual {p8}, Lcoil/util/ImageLoaderOptions;->getRespectCacheHeaders()Z

    move-result v4

    invoke-direct {v3, p5, p4, v4}, Lcoil/fetch/HttpUriFetcher$Factory;-><init>(Lkotlin/Lazy;Lkotlin/Lazy;Z)V

    check-cast v3, Lcoil/fetch/Fetcher$Factory;

    .restart local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .local v3, "factory$iv":Lcoil/fetch/Fetcher$Factory;
    const/4 v4, 0x0

    .line 309
    .restart local v4    # "$i$f$add":I
    const-class v5, Landroid/net/Uri;

    invoke-virtual {v2, v3, v5}, Lcoil/ComponentRegistry$Builder;->add(Lcoil/fetch/Fetcher$Factory;Ljava/lang/Class;)Lcoil/ComponentRegistry$Builder;

    move-result-object v2

    .line 96
    .end local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .end local v3    # "factory$iv":Lcoil/fetch/Fetcher$Factory;
    .end local v4    # "$i$f$add":I
    new-instance v3, Lcoil/fetch/FileFetcher$Factory;

    invoke-direct {v3}, Lcoil/fetch/FileFetcher$Factory;-><init>()V

    check-cast v3, Lcoil/fetch/Fetcher$Factory;

    .restart local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .restart local v3    # "factory$iv":Lcoil/fetch/Fetcher$Factory;
    const/4 v4, 0x0

    .line 310
    .restart local v4    # "$i$f$add":I
    const-class v5, Ljava/io/File;

    invoke-virtual {v2, v3, v5}, Lcoil/ComponentRegistry$Builder;->add(Lcoil/fetch/Fetcher$Factory;Ljava/lang/Class;)Lcoil/ComponentRegistry$Builder;

    move-result-object v2

    .line 97
    .end local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .end local v3    # "factory$iv":Lcoil/fetch/Fetcher$Factory;
    .end local v4    # "$i$f$add":I
    new-instance v3, Lcoil/fetch/AssetUriFetcher$Factory;

    invoke-direct {v3}, Lcoil/fetch/AssetUriFetcher$Factory;-><init>()V

    check-cast v3, Lcoil/fetch/Fetcher$Factory;

    .restart local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .restart local v3    # "factory$iv":Lcoil/fetch/Fetcher$Factory;
    const/4 v4, 0x0

    .line 311
    .restart local v4    # "$i$f$add":I
    const-class v5, Landroid/net/Uri;

    invoke-virtual {v2, v3, v5}, Lcoil/ComponentRegistry$Builder;->add(Lcoil/fetch/Fetcher$Factory;Ljava/lang/Class;)Lcoil/ComponentRegistry$Builder;

    move-result-object v2

    .line 98
    .end local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .end local v3    # "factory$iv":Lcoil/fetch/Fetcher$Factory;
    .end local v4    # "$i$f$add":I
    new-instance v3, Lcoil/fetch/ContentUriFetcher$Factory;

    invoke-direct {v3}, Lcoil/fetch/ContentUriFetcher$Factory;-><init>()V

    check-cast v3, Lcoil/fetch/Fetcher$Factory;

    .restart local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .restart local v3    # "factory$iv":Lcoil/fetch/Fetcher$Factory;
    const/4 v4, 0x0

    .line 312
    .restart local v4    # "$i$f$add":I
    const-class v5, Landroid/net/Uri;

    invoke-virtual {v2, v3, v5}, Lcoil/ComponentRegistry$Builder;->add(Lcoil/fetch/Fetcher$Factory;Ljava/lang/Class;)Lcoil/ComponentRegistry$Builder;

    move-result-object v2

    .line 99
    .end local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .end local v3    # "factory$iv":Lcoil/fetch/Fetcher$Factory;
    .end local v4    # "$i$f$add":I
    new-instance v3, Lcoil/fetch/ResourceUriFetcher$Factory;

    invoke-direct {v3}, Lcoil/fetch/ResourceUriFetcher$Factory;-><init>()V

    check-cast v3, Lcoil/fetch/Fetcher$Factory;

    .restart local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .restart local v3    # "factory$iv":Lcoil/fetch/Fetcher$Factory;
    const/4 v4, 0x0

    .line 313
    .restart local v4    # "$i$f$add":I
    const-class v5, Landroid/net/Uri;

    invoke-virtual {v2, v3, v5}, Lcoil/ComponentRegistry$Builder;->add(Lcoil/fetch/Fetcher$Factory;Ljava/lang/Class;)Lcoil/ComponentRegistry$Builder;

    move-result-object v2

    .line 100
    .end local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .end local v3    # "factory$iv":Lcoil/fetch/Fetcher$Factory;
    .end local v4    # "$i$f$add":I
    new-instance v3, Lcoil/fetch/DrawableFetcher$Factory;

    invoke-direct {v3}, Lcoil/fetch/DrawableFetcher$Factory;-><init>()V

    check-cast v3, Lcoil/fetch/Fetcher$Factory;

    .restart local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .restart local v3    # "factory$iv":Lcoil/fetch/Fetcher$Factory;
    const/4 v4, 0x0

    .line 314
    .restart local v4    # "$i$f$add":I
    const-class v5, Landroid/graphics/drawable/Drawable;

    invoke-virtual {v2, v3, v5}, Lcoil/ComponentRegistry$Builder;->add(Lcoil/fetch/Fetcher$Factory;Ljava/lang/Class;)Lcoil/ComponentRegistry$Builder;

    move-result-object v2

    .line 101
    .end local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .end local v3    # "factory$iv":Lcoil/fetch/Fetcher$Factory;
    .end local v4    # "$i$f$add":I
    new-instance v3, Lcoil/fetch/BitmapFetcher$Factory;

    invoke-direct {v3}, Lcoil/fetch/BitmapFetcher$Factory;-><init>()V

    check-cast v3, Lcoil/fetch/Fetcher$Factory;

    .restart local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .restart local v3    # "factory$iv":Lcoil/fetch/Fetcher$Factory;
    const/4 v4, 0x0

    .line 315
    .restart local v4    # "$i$f$add":I
    const-class v5, Landroid/graphics/Bitmap;

    invoke-virtual {v2, v3, v5}, Lcoil/ComponentRegistry$Builder;->add(Lcoil/fetch/Fetcher$Factory;Ljava/lang/Class;)Lcoil/ComponentRegistry$Builder;

    move-result-object v2

    .line 102
    .end local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .end local v3    # "factory$iv":Lcoil/fetch/Fetcher$Factory;
    .end local v4    # "$i$f$add":I
    new-instance v3, Lcoil/fetch/ByteBufferFetcher$Factory;

    invoke-direct {v3}, Lcoil/fetch/ByteBufferFetcher$Factory;-><init>()V

    check-cast v3, Lcoil/fetch/Fetcher$Factory;

    .restart local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .restart local v3    # "factory$iv":Lcoil/fetch/Fetcher$Factory;
    const/4 v4, 0x0

    .line 316
    .restart local v4    # "$i$f$add":I
    const-class v5, Ljava/nio/ByteBuffer;

    invoke-virtual {v2, v3, v5}, Lcoil/ComponentRegistry$Builder;->add(Lcoil/fetch/Fetcher$Factory;Ljava/lang/Class;)Lcoil/ComponentRegistry$Builder;

    move-result-object v2

    .line 104
    .end local v2    # "this_$iv":Lcoil/ComponentRegistry$Builder;
    .end local v3    # "factory$iv":Lcoil/fetch/Fetcher$Factory;
    .end local v4    # "$i$f$add":I
    new-instance v3, Lcoil/decode/BitmapFactoryDecoder$Factory;

    invoke-virtual {p8}, Lcoil/util/ImageLoaderOptions;->getBitmapFactoryMaxParallelism()I

    move-result v4

    invoke-virtual {p8}, Lcoil/util/ImageLoaderOptions;->getBitmapFactoryExifOrientationPolicy()Lcoil/decode/ExifOrientationPolicy;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Lcoil/decode/BitmapFactoryDecoder$Factory;-><init>(ILcoil/decode/ExifOrientationPolicy;)V

    check-cast v3, Lcoil/decode/Decoder$Factory;

    invoke-virtual {v2, v3}, Lcoil/ComponentRegistry$Builder;->add(Lcoil/decode/Decoder$Factory;)Lcoil/ComponentRegistry$Builder;

    move-result-object v2

    .line 105
    invoke-virtual {v2}, Lcoil/ComponentRegistry$Builder;->build()Lcoil/ComponentRegistry;

    move-result-object v2

    iput-object v2, p0, Lcoil/RealImageLoader;->components:Lcoil/ComponentRegistry;

    .line 106
    invoke-virtual {p0}, Lcoil/RealImageLoader;->getComponents()Lcoil/ComponentRegistry;

    move-result-object v2

    invoke-virtual {v2}, Lcoil/ComponentRegistry;->getInterceptors()Ljava/util/List;

    move-result-object v2

    check-cast v2, Ljava/util/Collection;

    new-instance v3, Lcoil/intercept/EngineInterceptor;

    move-object v4, p0

    check-cast v4, Lcoil/ImageLoader;

    invoke-direct {v3, v4, v1, p9}, Lcoil/intercept/EngineInterceptor;-><init>(Lcoil/ImageLoader;Lcoil/request/RequestService;Lcoil/util/Logger;)V

    invoke-static {v2, v3}, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection;Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    iput-object v1, p0, Lcoil/RealImageLoader;->interceptors:Ljava/util/List;

    .line 107
    new-instance v1, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v2, 0x0

    invoke-direct {v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v1, p0, Lcoil/RealImageLoader;->shutdown:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 109
    nop

    .line 111
    invoke-virtual {v0}, Lcoil/util/SystemCallbacks;->register()V

    .line 112
    nop

    .line 65
    return-void
.end method

.method public static final synthetic access$executeMain(Lcoil/RealImageLoader;Lcoil/request/ImageRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 1
    .param p0, "$this"    # Lcoil/RealImageLoader;
    .param p1, "initialRequest"    # Lcoil/request/ImageRequest;
    .param p2, "type"    # I
    .param p3, "$completion"    # Lkotlin/coroutines/Continuation;

    .line 65
    invoke-direct {p0, p1, p2, p3}, Lcoil/RealImageLoader;->executeMain(Lcoil/request/ImageRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static final synthetic access$getInterceptors$p(Lcoil/RealImageLoader;)Ljava/util/List;
    .locals 1
    .param p0, "$this"    # Lcoil/RealImageLoader;

    .line 65
    iget-object v0, p0, Lcoil/RealImageLoader;->interceptors:Ljava/util/List;

    return-object v0
.end method

.method private final executeMain(Lcoil/request/ImageRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 19
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcoil/request/ImageRequest;",
            "I",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lcoil/request/ImageResult;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    move-object/from16 v0, p3

    instance-of v1, v0, Lcoil/RealImageLoader$executeMain$1;

    if-eqz v1, :cond_0

    move-object v1, v0

    check-cast v1, Lcoil/RealImageLoader$executeMain$1;

    iget v2, v1, Lcoil/RealImageLoader$executeMain$1;->label:I

    const/high16 v3, -0x80000000

    and-int/2addr v2, v3

    if-eqz v2, :cond_0

    iget v0, v1, Lcoil/RealImageLoader$executeMain$1;->label:I

    sub-int/2addr v0, v3

    iput v0, v1, Lcoil/RealImageLoader$executeMain$1;->label:I

    move-object v0, v1

    move-object/from16 v2, p0

    goto :goto_0

    :cond_0
    new-instance v1, Lcoil/RealImageLoader$executeMain$1;

    move-object/from16 v2, p0

    invoke-direct {v1, v2, v0}, Lcoil/RealImageLoader$executeMain$1;-><init>(Lcoil/RealImageLoader;Lkotlin/coroutines/Continuation;)V

    move-object v0, v1

    .local v1, "$continuation":Lkotlin/coroutines/Continuation;
    :goto_0
    iget-object v3, v1, Lcoil/RealImageLoader$executeMain$1;->result:Ljava/lang/Object;

    .local v3, "$result":Ljava/lang/Object;
    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object v0

    .line 144
    iget v4, v1, Lcoil/RealImageLoader$executeMain$1;->label:I

    const/4 v5, 0x0

    packed-switch v4, :pswitch_data_0

    .end local v1    # "$continuation":Lkotlin/coroutines/Continuation;
    .end local v3    # "$result":Ljava/lang/Object;
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "call to \'resume\' before \'invoke\' with coroutine"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .restart local v1    # "$continuation":Lkotlin/coroutines/Continuation;
    .restart local v3    # "$result":Ljava/lang/Object;
    :pswitch_0
    iget-object v0, v1, Lcoil/RealImageLoader$executeMain$1;->L$3:Ljava/lang/Object;

    move-object v4, v0

    check-cast v4, Lcoil/EventListener;

    .local v4, "eventListener":Lcoil/EventListener;
    iget-object v0, v1, Lcoil/RealImageLoader$executeMain$1;->L$2:Ljava/lang/Object;

    move-object v5, v0

    check-cast v5, Lcoil/request/ImageRequest;

    .local v5, "request":Lcoil/request/ImageRequest;
    iget-object v0, v1, Lcoil/RealImageLoader$executeMain$1;->L$1:Ljava/lang/Object;

    move-object v6, v0

    check-cast v6, Lcoil/request/RequestDelegate;

    .local v6, "requestDelegate":Lcoil/request/RequestDelegate;
    iget-object v0, v1, Lcoil/RealImageLoader$executeMain$1;->L$0:Ljava/lang/Object;

    move-object v7, v0

    check-cast v7, Lcoil/RealImageLoader;

    .local v7, "this":Lcoil/RealImageLoader;
    :try_start_0
    invoke-static {v3}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-object v2, v3

    goto/16 :goto_7

    .line 200
    :catchall_0
    move-exception v0

    goto/16 :goto_9

    .line 144
    .end local v4    # "eventListener":Lcoil/EventListener;
    .end local v5    # "request":Lcoil/request/ImageRequest;
    .end local v6    # "requestDelegate":Lcoil/request/RequestDelegate;
    .end local v7    # "this":Lcoil/RealImageLoader;
    :pswitch_1
    iget-object v4, v1, Lcoil/RealImageLoader$executeMain$1;->L$4:Ljava/lang/Object;

    check-cast v4, Landroid/graphics/Bitmap;

    .local v4, "placeholderBitmap":Landroid/graphics/Bitmap;
    iget-object v6, v1, Lcoil/RealImageLoader$executeMain$1;->L$3:Ljava/lang/Object;

    check-cast v6, Lcoil/EventListener;

    .local v6, "eventListener":Lcoil/EventListener;
    iget-object v7, v1, Lcoil/RealImageLoader$executeMain$1;->L$2:Ljava/lang/Object;

    check-cast v7, Lcoil/request/ImageRequest;

    .local v7, "request":Lcoil/request/ImageRequest;
    iget-object v8, v1, Lcoil/RealImageLoader$executeMain$1;->L$1:Ljava/lang/Object;

    check-cast v8, Lcoil/request/RequestDelegate;

    .local v8, "requestDelegate":Lcoil/request/RequestDelegate;
    iget-object v9, v1, Lcoil/RealImageLoader$executeMain$1;->L$0:Ljava/lang/Object;

    check-cast v9, Lcoil/RealImageLoader;

    .local v9, "this":Lcoil/RealImageLoader;
    :try_start_1
    invoke-static {v3}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-object v5, v3

    move-object/from16 v18, v9

    move-object v9, v4

    move-object v4, v6

    move-object v6, v7

    move-object v7, v8

    move-object/from16 v8, v18

    goto/16 :goto_6

    .line 200
    .end local v4    # "placeholderBitmap":Landroid/graphics/Bitmap;
    :catchall_1
    move-exception v0

    move-object v4, v6

    move-object v5, v7

    move-object v6, v8

    move-object v7, v9

    goto/16 :goto_9

    .line 144
    .end local v6    # "eventListener":Lcoil/EventListener;
    .end local v7    # "request":Lcoil/request/ImageRequest;
    .end local v8    # "requestDelegate":Lcoil/request/RequestDelegate;
    .end local v9    # "this":Lcoil/RealImageLoader;
    :pswitch_2
    iget-object v4, v1, Lcoil/RealImageLoader$executeMain$1;->L$3:Ljava/lang/Object;

    check-cast v4, Lcoil/EventListener;

    .local v4, "eventListener":Lcoil/EventListener;
    iget-object v6, v1, Lcoil/RealImageLoader$executeMain$1;->L$2:Ljava/lang/Object;

    check-cast v6, Lcoil/request/ImageRequest;

    .local v6, "request":Lcoil/request/ImageRequest;
    iget-object v7, v1, Lcoil/RealImageLoader$executeMain$1;->L$1:Ljava/lang/Object;

    check-cast v7, Lcoil/request/RequestDelegate;

    .local v7, "requestDelegate":Lcoil/request/RequestDelegate;
    iget-object v8, v1, Lcoil/RealImageLoader$executeMain$1;->L$0:Ljava/lang/Object;

    check-cast v8, Lcoil/RealImageLoader;

    .local v8, "this":Lcoil/RealImageLoader;
    :try_start_2
    invoke-static {v3}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    goto :goto_1

    .line 200
    :catchall_2
    move-exception v0

    move-object v5, v6

    move-object v6, v7

    move-object v7, v8

    goto/16 :goto_9

    .line 144
    .end local v4    # "eventListener":Lcoil/EventListener;
    .end local v6    # "request":Lcoil/request/ImageRequest;
    .end local v7    # "requestDelegate":Lcoil/request/RequestDelegate;
    .end local v8    # "this":Lcoil/RealImageLoader;
    :pswitch_3
    invoke-static {v3}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object/from16 v7, p0

    .local v7, "this":Lcoil/RealImageLoader;
    move/from16 v4, p2

    .local v4, "type":I
    move-object/from16 v6, p1

    .line 146
    .local v6, "initialRequest":Lcoil/request/ImageRequest;
    iget-object v8, v7, Lcoil/RealImageLoader;->requestService:Lcoil/request/RequestService;

    invoke-interface {v1}, Lkotlin/coroutines/Continuation;->getContext()Lkotlin/coroutines/CoroutineContext;

    move-result-object v9

    invoke-static {v9}, Lkotlinx/coroutines/JobKt;->getJob(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Job;

    move-result-object v9

    invoke-virtual {v8, v6, v9}, Lcoil/request/RequestService;->requestDelegate(Lcoil/request/ImageRequest;Lkotlinx/coroutines/Job;)Lcoil/request/RequestDelegate;

    move-result-object v8

    .line 147
    move-object v9, v8

    .line 317
    .local v9, "$this$executeMain_u24lambda_u241":Lcoil/request/RequestDelegate;
    const/4 v10, 0x0

    .line 147
    .local v10, "$i$a$-apply-RealImageLoader$executeMain$requestDelegate$1":I
    invoke-interface {v9}, Lcoil/request/RequestDelegate;->assertActive()V

    .line 146
    .end local v9    # "$this$executeMain_u24lambda_u241":Lcoil/request/RequestDelegate;
    .end local v10    # "$i$a$-apply-RealImageLoader$executeMain$requestDelegate$1":I
    nop

    .line 150
    .local v8, "requestDelegate":Lcoil/request/RequestDelegate;
    const/4 v9, 0x1

    invoke-static {v6, v5, v9, v5}, Lcoil/request/ImageRequest;->newBuilder$default(Lcoil/request/ImageRequest;Landroid/content/Context;ILjava/lang/Object;)Lcoil/request/ImageRequest$Builder;

    move-result-object v10

    invoke-virtual {v7}, Lcoil/RealImageLoader;->getDefaults()Lcoil/request/DefaultRequestOptions;

    move-result-object v11

    invoke-virtual {v10, v11}, Lcoil/request/ImageRequest$Builder;->defaults(Lcoil/request/DefaultRequestOptions;)Lcoil/request/ImageRequest$Builder;

    move-result-object v10

    invoke-virtual {v10}, Lcoil/request/ImageRequest$Builder;->build()Lcoil/request/ImageRequest;

    move-result-object v6

    .line 153
    .local v6, "request":Lcoil/request/ImageRequest;
    iget-object v10, v7, Lcoil/RealImageLoader;->eventListenerFactory:Lcoil/EventListener$Factory;

    invoke-interface {v10, v6}, Lcoil/EventListener$Factory;->create(Lcoil/request/ImageRequest;)Lcoil/EventListener;

    move-result-object v10

    .line 155
    .local v10, "eventListener":Lcoil/EventListener;
    nop

    .line 157
    :try_start_3
    invoke-virtual {v6}, Lcoil/request/ImageRequest;->getData()Ljava/lang/Object;

    move-result-object v11

    sget-object v12, Lcoil/request/NullRequestData;->INSTANCE:Lcoil/request/NullRequestData;

    if-eq v11, v12, :cond_c

    .line 162
    invoke-interface {v8}, Lcoil/request/RequestDelegate;->start()V

    .line 165
    if-nez v4, :cond_2

    .line 166
    .end local v4    # "type":I
    invoke-virtual {v6}, Lcoil/request/ImageRequest;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    move-result-object v4

    iput-object v7, v1, Lcoil/RealImageLoader$executeMain$1;->L$0:Ljava/lang/Object;

    iput-object v8, v1, Lcoil/RealImageLoader$executeMain$1;->L$1:Ljava/lang/Object;

    iput-object v6, v1, Lcoil/RealImageLoader$executeMain$1;->L$2:Ljava/lang/Object;

    iput-object v10, v1, Lcoil/RealImageLoader$executeMain$1;->L$3:Ljava/lang/Object;

    iput v9, v1, Lcoil/RealImageLoader$executeMain$1;->label:I

    invoke-static {v4, v1}, Lcoil/util/-Lifecycles;->awaitStarted(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v4
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_3

    if-ne v4, v0, :cond_1

    .line 144
    return-object v0

    .line 166
    :cond_1
    move-object v4, v10

    move-object/from16 v18, v8

    move-object v8, v7

    move-object/from16 v7, v18

    .line 170
    .end local v10    # "eventListener":Lcoil/EventListener;
    .local v4, "eventListener":Lcoil/EventListener;
    .local v7, "requestDelegate":Lcoil/request/RequestDelegate;
    .local v8, "this":Lcoil/RealImageLoader;
    :goto_1
    goto :goto_2

    .line 165
    .local v4, "type":I
    .local v7, "this":Lcoil/RealImageLoader;
    .local v8, "requestDelegate":Lcoil/request/RequestDelegate;
    .restart local v10    # "eventListener":Lcoil/EventListener;
    :cond_2
    move-object v4, v10

    move-object/from16 v18, v8

    move-object v8, v7

    move-object/from16 v7, v18

    .line 170
    .end local v10    # "eventListener":Lcoil/EventListener;
    .local v4, "eventListener":Lcoil/EventListener;
    .local v7, "requestDelegate":Lcoil/request/RequestDelegate;
    .local v8, "this":Lcoil/RealImageLoader;
    :goto_2
    :try_start_4
    invoke-virtual {v8}, Lcoil/RealImageLoader;->getMemoryCache()Lcoil/memory/MemoryCache;

    move-result-object v9

    if-eqz v9, :cond_4

    invoke-virtual {v6}, Lcoil/request/ImageRequest;->getPlaceholderMemoryCacheKey()Lcoil/memory/MemoryCache$Key;

    move-result-object v10

    .local v9, "$this$get$iv":Lcoil/memory/MemoryCache;
    .local v10, "key$iv":Lcoil/memory/MemoryCache$Key;
    const/4 v11, 0x0

    .line 318
    .local v11, "$i$f$get":I
    if-eqz v10, :cond_3

    .line 319
    .local v10, "p0$iv":Lcoil/memory/MemoryCache$Key;
    const/4 v12, 0x0

    .line 318
    .local v12, "$i$a$-let--Utils$get$1$iv":I
    invoke-interface {v9, v10}, Lcoil/memory/MemoryCache;->get(Lcoil/memory/MemoryCache$Key;)Lcoil/memory/MemoryCache$Value;

    move-result-object v13

    .end local v9    # "$this$get$iv":Lcoil/memory/MemoryCache;
    .end local v10    # "p0$iv":Lcoil/memory/MemoryCache$Key;
    .end local v12    # "$i$a$-let--Utils$get$1$iv":I
    goto :goto_3

    .restart local v9    # "$this$get$iv":Lcoil/memory/MemoryCache;
    .local v10, "key$iv":Lcoil/memory/MemoryCache$Key;
    :cond_3
    move-object v13, v5

    .line 170
    .end local v9    # "$this$get$iv":Lcoil/memory/MemoryCache;
    .end local v10    # "key$iv":Lcoil/memory/MemoryCache$Key;
    .end local v11    # "$i$f$get":I
    :goto_3
    if-eqz v13, :cond_4

    invoke-virtual {v13}, Lcoil/memory/MemoryCache$Value;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v9

    goto :goto_4

    :cond_4
    move-object v9, v5

    .line 171
    .local v9, "placeholderBitmap":Landroid/graphics/Bitmap;
    :goto_4
    if-eqz v9, :cond_5

    invoke-virtual {v6}, Lcoil/request/ImageRequest;->getContext()Landroid/content/Context;

    move-result-object v10

    .local v10, "context$iv":Landroid/content/Context;
    move-object v11, v9

    .local v11, "$this$toDrawable$iv":Landroid/graphics/Bitmap;
    const/4 v12, 0x0

    .line 320
    .local v12, "$i$f$toDrawable":I
    invoke-virtual {v10}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v13

    .local v13, "resources$iv$iv":Landroid/content/res/Resources;
    move-object v14, v11

    .local v14, "$this$toDrawable$iv$iv":Landroid/graphics/Bitmap;
    const/4 v15, 0x0

    .line 321
    .local v15, "$i$f$toDrawable":I
    new-instance v5, Landroid/graphics/drawable/BitmapDrawable;

    invoke-direct {v5, v13, v14}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    .line 320
    .end local v13    # "resources$iv$iv":Landroid/content/res/Resources;
    .end local v14    # "$this$toDrawable$iv$iv":Landroid/graphics/Bitmap;
    .end local v15    # "$i$f$toDrawable":I
    nop

    .line 171
    .end local v10    # "context$iv":Landroid/content/Context;
    .end local v11    # "$this$toDrawable$iv":Landroid/graphics/Bitmap;
    .end local v12    # "$i$f$toDrawable":I
    check-cast v5, Landroid/graphics/drawable/Drawable;

    goto :goto_5

    :cond_5
    invoke-virtual {v6}, Lcoil/request/ImageRequest;->getPlaceholder()Landroid/graphics/drawable/Drawable;

    move-result-object v5

    .line 172
    .local v5, "placeholder":Landroid/graphics/drawable/Drawable;
    :goto_5
    invoke-virtual {v6}, Lcoil/request/ImageRequest;->getTarget()Lcoil/target/Target;

    move-result-object v10

    if-eqz v10, :cond_6

    invoke-interface {v10, v5}, Lcoil/target/Target;->onStart(Landroid/graphics/drawable/Drawable;)V

    nop

    .line 173
    .end local v5    # "placeholder":Landroid/graphics/drawable/Drawable;
    :cond_6
    invoke-interface {v4, v6}, Lcoil/EventListener;->onStart(Lcoil/request/ImageRequest;)V

    .line 174
    invoke-virtual {v6}, Lcoil/request/ImageRequest;->getListener()Lcoil/request/ImageRequest$Listener;

    move-result-object v5

    if-eqz v5, :cond_7

    invoke-interface {v5, v6}, Lcoil/request/ImageRequest$Listener;->onStart(Lcoil/request/ImageRequest;)V

    .line 177
    :cond_7
    invoke-interface {v4, v6}, Lcoil/EventListener;->resolveSizeStart(Lcoil/request/ImageRequest;)V

    .line 178
    invoke-virtual {v6}, Lcoil/request/ImageRequest;->getSizeResolver()Lcoil/size/SizeResolver;

    move-result-object v5

    iput-object v8, v1, Lcoil/RealImageLoader$executeMain$1;->L$0:Ljava/lang/Object;

    iput-object v7, v1, Lcoil/RealImageLoader$executeMain$1;->L$1:Ljava/lang/Object;

    iput-object v6, v1, Lcoil/RealImageLoader$executeMain$1;->L$2:Ljava/lang/Object;

    iput-object v4, v1, Lcoil/RealImageLoader$executeMain$1;->L$3:Ljava/lang/Object;

    iput-object v9, v1, Lcoil/RealImageLoader$executeMain$1;->L$4:Ljava/lang/Object;

    const/4 v10, 0x2

    iput v10, v1, Lcoil/RealImageLoader$executeMain$1;->label:I

    invoke-interface {v5, v1}, Lcoil/size/SizeResolver;->size(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v5

    if-ne v5, v0, :cond_8

    .line 144
    return-object v0

    :cond_8
    :goto_6
    check-cast v5, Lcoil/size/Size;

    .line 179
    .local v5, "size":Lcoil/size/Size;
    invoke-interface {v4, v6, v5}, Lcoil/EventListener;->resolveSizeEnd(Lcoil/request/ImageRequest;Lcoil/size/Size;)V

    .line 182
    invoke-virtual {v6}, Lcoil/request/ImageRequest;->getInterceptorDispatcher()Lkotlinx/coroutines/CoroutineDispatcher;

    move-result-object v10

    move-object v15, v10

    check-cast v15, Lkotlin/coroutines/CoroutineContext;

    new-instance v17, Lcoil/RealImageLoader$executeMain$result$1;

    const/16 v16, 0x0

    move-object/from16 v10, v17

    move-object v11, v6

    move-object v12, v8

    move-object v13, v5

    move-object v14, v4

    move-object v2, v15

    move-object v15, v9

    invoke-direct/range {v10 .. v16}, Lcoil/RealImageLoader$executeMain$result$1;-><init>(Lcoil/request/ImageRequest;Lcoil/RealImageLoader;Lcoil/size/Size;Lcoil/EventListener;Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)V

    move-object/from16 v10, v17

    check-cast v10, Lkotlin/jvm/functions/Function2;

    iput-object v8, v1, Lcoil/RealImageLoader$executeMain$1;->L$0:Ljava/lang/Object;

    iput-object v7, v1, Lcoil/RealImageLoader$executeMain$1;->L$1:Ljava/lang/Object;

    iput-object v6, v1, Lcoil/RealImageLoader$executeMain$1;->L$2:Ljava/lang/Object;

    iput-object v4, v1, Lcoil/RealImageLoader$executeMain$1;->L$3:Ljava/lang/Object;

    const/4 v11, 0x0

    iput-object v11, v1, Lcoil/RealImageLoader$executeMain$1;->L$4:Ljava/lang/Object;

    const/4 v11, 0x3

    iput v11, v1, Lcoil/RealImageLoader$executeMain$1;->label:I

    invoke-static {v2, v10, v1}, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v2
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .end local v5    # "size":Lcoil/size/Size;
    .end local v9    # "placeholderBitmap":Landroid/graphics/Bitmap;
    if-ne v2, v0, :cond_9

    .line 144
    return-object v0

    .line 182
    :cond_9
    move-object v5, v6

    move-object v6, v7

    move-object v7, v8

    .line 144
    .end local v8    # "this":Lcoil/RealImageLoader;
    .local v5, "request":Lcoil/request/ImageRequest;
    .local v6, "requestDelegate":Lcoil/request/RequestDelegate;
    .local v7, "this":Lcoil/RealImageLoader;
    :goto_7
    :try_start_5
    check-cast v2, Lcoil/request/ImageResult;

    move-object v0, v2

    .line 195
    .local v0, "result":Lcoil/request/ImageResult;
    nop

    .line 196
    instance-of v2, v0, Lcoil/request/SuccessResult;

    if-eqz v2, :cond_a

    move-object v2, v0

    check-cast v2, Lcoil/request/SuccessResult;

    invoke-virtual {v5}, Lcoil/request/ImageRequest;->getTarget()Lcoil/target/Target;

    move-result-object v8

    invoke-direct {v7, v2, v8, v4}, Lcoil/RealImageLoader;->onSuccess(Lcoil/request/SuccessResult;Lcoil/target/Target;Lcoil/EventListener;)V

    goto :goto_8

    .line 197
    :cond_a
    instance-of v2, v0, Lcoil/request/ErrorResult;

    if-eqz v2, :cond_b

    move-object v2, v0

    check-cast v2, Lcoil/request/ErrorResult;

    invoke-virtual {v5}, Lcoil/request/ImageRequest;->getTarget()Lcoil/target/Target;

    move-result-object v8

    invoke-direct {v7, v2, v8, v4}, Lcoil/RealImageLoader;->onError(Lcoil/request/ErrorResult;Lcoil/target/Target;Lcoil/EventListener;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 199
    :cond_b
    :goto_8
    nop

    .line 211
    .end local v0    # "result":Lcoil/request/ImageResult;
    .end local v4    # "eventListener":Lcoil/EventListener;
    .end local v5    # "request":Lcoil/request/ImageRequest;
    .end local v7    # "this":Lcoil/RealImageLoader;
    invoke-interface {v6}, Lcoil/request/RequestDelegate;->complete()V

    .line 199
    .end local v6    # "requestDelegate":Lcoil/request/RequestDelegate;
    return-object v0

    .line 158
    .local v6, "request":Lcoil/request/ImageRequest;
    .restart local v7    # "this":Lcoil/RealImageLoader;
    .local v8, "requestDelegate":Lcoil/request/RequestDelegate;
    .local v10, "eventListener":Lcoil/EventListener;
    :cond_c
    :try_start_6
    new-instance v0, Lcoil/request/NullRequestDataException;

    invoke-direct {v0}, Lcoil/request/NullRequestDataException;-><init>()V

    .end local v1    # "$continuation":Lkotlin/coroutines/Continuation;
    .end local v3    # "$result":Ljava/lang/Object;
    .end local v6    # "request":Lcoil/request/ImageRequest;
    .end local v7    # "this":Lcoil/RealImageLoader;
    .end local v8    # "requestDelegate":Lcoil/request/RequestDelegate;
    .end local v10    # "eventListener":Lcoil/EventListener;
    throw v0
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_3

    .line 200
    .restart local v1    # "$continuation":Lkotlin/coroutines/Continuation;
    .restart local v3    # "$result":Ljava/lang/Object;
    .restart local v6    # "request":Lcoil/request/ImageRequest;
    .restart local v7    # "this":Lcoil/RealImageLoader;
    .restart local v8    # "requestDelegate":Lcoil/request/RequestDelegate;
    .restart local v10    # "eventListener":Lcoil/EventListener;
    :catchall_3
    move-exception v0

    move-object v5, v6

    move-object v6, v8

    move-object v4, v10

    .line 201
    .end local v8    # "requestDelegate":Lcoil/request/RequestDelegate;
    .end local v10    # "eventListener":Lcoil/EventListener;
    .local v0, "throwable":Ljava/lang/Throwable;
    .restart local v4    # "eventListener":Lcoil/EventListener;
    .restart local v5    # "request":Lcoil/request/ImageRequest;
    .local v6, "requestDelegate":Lcoil/request/RequestDelegate;
    :goto_9
    :try_start_7
    instance-of v2, v0, Ljava/util/concurrent/CancellationException;

    if-nez v2, :cond_d

    .line 206
    iget-object v2, v7, Lcoil/RealImageLoader;->requestService:Lcoil/request/RequestService;

    invoke-virtual {v2, v5, v0}, Lcoil/request/RequestService;->errorResult(Lcoil/request/ImageRequest;Ljava/lang/Throwable;)Lcoil/request/ErrorResult;

    move-result-object v2

    .line 207
    .local v2, "result":Lcoil/request/ErrorResult;
    invoke-virtual {v5}, Lcoil/request/ImageRequest;->getTarget()Lcoil/target/Target;

    move-result-object v8

    invoke-direct {v7, v2, v8, v4}, Lcoil/RealImageLoader;->onError(Lcoil/request/ErrorResult;Lcoil/target/Target;Lcoil/EventListener;)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_4

    .line 208
    .end local v4    # "eventListener":Lcoil/EventListener;
    .end local v5    # "request":Lcoil/request/ImageRequest;
    .end local v7    # "this":Lcoil/RealImageLoader;
    nop

    .line 211
    .end local v0    # "throwable":Ljava/lang/Throwable;
    .end local v2    # "result":Lcoil/request/ErrorResult;
    invoke-interface {v6}, Lcoil/request/RequestDelegate;->complete()V

    .line 208
    .end local v6    # "requestDelegate":Lcoil/request/RequestDelegate;
    return-object v2

    .line 202
    .restart local v0    # "throwable":Ljava/lang/Throwable;
    .restart local v4    # "eventListener":Lcoil/EventListener;
    .restart local v5    # "request":Lcoil/request/ImageRequest;
    .restart local v6    # "requestDelegate":Lcoil/request/RequestDelegate;
    .restart local v7    # "this":Lcoil/RealImageLoader;
    :cond_d
    :try_start_8
    invoke-direct {v7, v5, v4}, Lcoil/RealImageLoader;->onCancel(Lcoil/request/ImageRequest;Lcoil/EventListener;)V

    .line 203
    .end local v4    # "eventListener":Lcoil/EventListener;
    .end local v5    # "request":Lcoil/request/ImageRequest;
    .end local v7    # "this":Lcoil/RealImageLoader;
    nop

    .end local v1    # "$continuation":Lkotlin/coroutines/Continuation;
    .end local v3    # "$result":Ljava/lang/Object;
    .end local v6    # "requestDelegate":Lcoil/request/RequestDelegate;
    throw v0
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_4

    .line 211
    .end local v0    # "throwable":Ljava/lang/Throwable;
    .restart local v1    # "$continuation":Lkotlin/coroutines/Continuation;
    .restart local v3    # "$result":Ljava/lang/Object;
    .restart local v6    # "requestDelegate":Lcoil/request/RequestDelegate;
    :catchall_4
    move-exception v0

    invoke-interface {v6}, Lcoil/request/RequestDelegate;->complete()V

    throw v0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static getDiskCache$delegate(Lcoil/RealImageLoader;)Ljava/lang/Object;
    .locals 1
    .param p0, "<this>"    # Lcoil/RealImageLoader;

    .line 82
    iget-object v0, p0, Lcoil/RealImageLoader;->diskCacheLazy:Lkotlin/Lazy;

    return-object v0
.end method

.method private static getMemoryCache$delegate(Lcoil/RealImageLoader;)Ljava/lang/Object;
    .locals 1
    .param p0, "<this>"    # Lcoil/RealImageLoader;

    .line 81
    iget-object v0, p0, Lcoil/RealImageLoader;->memoryCacheLazy:Lkotlin/Lazy;

    return-object v0
.end method

.method private final onCancel(Lcoil/request/ImageRequest;Lcoil/EventListener;)V
    .locals 7
    .param p1, "request"    # Lcoil/request/ImageRequest;
    .param p2, "eventListener"    # Lcoil/EventListener;

    .line 261
    iget-object v0, p0, Lcoil/RealImageLoader;->logger:Lcoil/util/Logger;

    if-eqz v0, :cond_1

    const-string v1, "RealImageLoader"

    .local v1, "tag$iv":Ljava/lang/String;
    const/4 v2, 0x4

    .local v0, "$this$log$iv":Lcoil/util/Logger;
    .local v2, "priority$iv":I
    const/4 v3, 0x0

    .line 360
    .local v3, "$i$f$log":I
    invoke-interface {v0}, Lcoil/util/Logger;->getLevel()I

    move-result v4

    if-gt v4, v2, :cond_0

    .line 361
    const/4 v4, 0x0

    .line 262
    .local v4, "$i$a$-log-RealImageLoader$onCancel$1":I
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "\ud83c\udfd7  Cancelled - "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {p1}, Lcoil/request/ImageRequest;->getData()Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 361
    .end local v4    # "$i$a$-log-RealImageLoader$onCancel$1":I
    const/4 v5, 0x0

    invoke-interface {v0, v1, v2, v4, v5}, Lcoil/util/Logger;->log(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V

    .line 363
    :cond_0
    nop

    .line 264
    .end local v0    # "$this$log$iv":Lcoil/util/Logger;
    .end local v1    # "tag$iv":Ljava/lang/String;
    .end local v2    # "priority$iv":I
    .end local v3    # "$i$f$log":I
    :cond_1
    invoke-interface {p2, p1}, Lcoil/EventListener;->onCancel(Lcoil/request/ImageRequest;)V

    .line 265
    invoke-virtual {p1}, Lcoil/request/ImageRequest;->getListener()Lcoil/request/ImageRequest$Listener;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-interface {v0, p1}, Lcoil/request/ImageRequest$Listener;->onCancel(Lcoil/request/ImageRequest;)V

    .line 266
    :cond_2
    return-void
.end method

.method private final onError(Lcoil/request/ErrorResult;Lcoil/target/Target;Lcoil/EventListener;)V
    .locals 8
    .param p1, "result"    # Lcoil/request/ErrorResult;
    .param p2, "target"    # Lcoil/target/Target;
    .param p3, "eventListener"    # Lcoil/EventListener;

    .line 251
    invoke-virtual {p1}, Lcoil/request/ErrorResult;->getRequest()Lcoil/request/ImageRequest;

    move-result-object v0

    .line 252
    .local v0, "request":Lcoil/request/ImageRequest;
    iget-object v1, p0, Lcoil/RealImageLoader;->logger:Lcoil/util/Logger;

    if-eqz v1, :cond_1

    const-string v2, "RealImageLoader"

    .local v2, "tag$iv":Ljava/lang/String;
    const/4 v3, 0x4

    .local v1, "$this$log$iv":Lcoil/util/Logger;
    .local v3, "priority$iv":I
    const/4 v4, 0x0

    .line 341
    .local v4, "$i$f$log":I
    invoke-interface {v1}, Lcoil/util/Logger;->getLevel()I

    move-result v5

    if-gt v5, v3, :cond_0

    .line 342
    const/4 v5, 0x0

    .line 253
    .local v5, "$i$a$-log-RealImageLoader$onError$1":I
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "\ud83d\udea8 Failed - "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v0}, Lcoil/request/ImageRequest;->getData()Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " - "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {p1}, Lcoil/request/ErrorResult;->getThrowable()Ljava/lang/Throwable;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 342
    .end local v5    # "$i$a$-log-RealImageLoader$onError$1":I
    const/4 v6, 0x0

    invoke-interface {v1, v2, v3, v5, v6}, Lcoil/util/Logger;->log(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V

    .line 344
    :cond_0
    nop

    .line 255
    .end local v1    # "$this$log$iv":Lcoil/util/Logger;
    .end local v2    # "tag$iv":Ljava/lang/String;
    .end local v3    # "priority$iv":I
    .end local v4    # "$i$f$log":I
    :cond_1
    move-object v1, p0

    .local v1, "this_$iv":Lcoil/RealImageLoader;
    const/4 v2, 0x0

    .line 345
    .local v2, "$i$f$transition":I
    instance-of v3, p2, Lcoil/transition/TransitionTarget;

    if-nez v3, :cond_3

    .line 346
    const/4 v3, 0x0

    .line 255
    .local v3, "$i$a$-transition-RealImageLoader$onError$2":I
    if-eqz p2, :cond_2

    invoke-virtual {p1}, Lcoil/request/ErrorResult;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-interface {p2, v4}, Lcoil/target/Target;->onError(Landroid/graphics/drawable/Drawable;)V

    .line 346
    .end local v3    # "$i$a$-transition-RealImageLoader$onError$2":I
    :cond_2
    nop

    .line 347
    goto :goto_0

    .line 350
    :cond_3
    move-object v3, p1

    check-cast v3, Lcoil/request/ImageResult;

    invoke-virtual {v3}, Lcoil/request/ImageResult;->getRequest()Lcoil/request/ImageRequest;

    move-result-object v3

    invoke-virtual {v3}, Lcoil/request/ImageRequest;->getTransitionFactory()Lcoil/transition/Transition$Factory;

    move-result-object v3

    move-object v4, p2

    check-cast v4, Lcoil/transition/TransitionTarget;

    move-object v5, p1

    check-cast v5, Lcoil/request/ImageResult;

    invoke-interface {v3, v4, v5}, Lcoil/transition/Transition$Factory;->create(Lcoil/transition/TransitionTarget;Lcoil/request/ImageResult;)Lcoil/transition/Transition;

    move-result-object v3

    .line 351
    .local v3, "transition$iv":Lcoil/transition/Transition;
    instance-of v4, v3, Lcoil/transition/NoneTransition;

    if-eqz v4, :cond_4

    .line 352
    const/4 v4, 0x0

    .line 255
    .local v4, "$i$a$-transition-RealImageLoader$onError$2":I
    invoke-virtual {p1}, Lcoil/request/ErrorResult;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-interface {p2, v5}, Lcoil/target/Target;->onError(Landroid/graphics/drawable/Drawable;)V

    .line 352
    .end local v4    # "$i$a$-transition-RealImageLoader$onError$2":I
    nop

    .line 353
    goto :goto_0

    .line 356
    :cond_4
    move-object v4, p1

    check-cast v4, Lcoil/request/ImageResult;

    invoke-virtual {v4}, Lcoil/request/ImageResult;->getRequest()Lcoil/request/ImageRequest;

    move-result-object v4

    invoke-interface {p3, v4, v3}, Lcoil/EventListener;->transitionStart(Lcoil/request/ImageRequest;Lcoil/transition/Transition;)V

    .line 357
    invoke-interface {v3}, Lcoil/transition/Transition;->transition()V

    .line 358
    move-object v4, p1

    check-cast v4, Lcoil/request/ImageResult;

    invoke-virtual {v4}, Lcoil/request/ImageResult;->getRequest()Lcoil/request/ImageRequest;

    move-result-object v4

    invoke-interface {p3, v4, v3}, Lcoil/EventListener;->transitionEnd(Lcoil/request/ImageRequest;Lcoil/transition/Transition;)V

    .line 359
    nop

    .line 256
    .end local v1    # "this_$iv":Lcoil/RealImageLoader;
    .end local v2    # "$i$f$transition":I
    .end local v3    # "transition$iv":Lcoil/transition/Transition;
    :goto_0
    invoke-interface {p3, v0, p1}, Lcoil/EventListener;->onError(Lcoil/request/ImageRequest;Lcoil/request/ErrorResult;)V

    .line 257
    invoke-virtual {v0}, Lcoil/request/ImageRequest;->getListener()Lcoil/request/ImageRequest$Listener;

    move-result-object v1

    if-eqz v1, :cond_5

    invoke-interface {v1, v0, p1}, Lcoil/request/ImageRequest$Listener;->onError(Lcoil/request/ImageRequest;Lcoil/request/ErrorResult;)V

    .line 258
    :cond_5
    return-void
.end method

.method private final onSuccess(Lcoil/request/SuccessResult;Lcoil/target/Target;Lcoil/EventListener;)V
    .locals 9
    .param p1, "result"    # Lcoil/request/SuccessResult;
    .param p2, "target"    # Lcoil/target/Target;
    .param p3, "eventListener"    # Lcoil/EventListener;

    .line 236
    invoke-virtual {p1}, Lcoil/request/SuccessResult;->getRequest()Lcoil/request/ImageRequest;

    move-result-object v0

    .line 237
    .local v0, "request":Lcoil/request/ImageRequest;
    invoke-virtual {p1}, Lcoil/request/SuccessResult;->getDataSource()Lcoil/decode/DataSource;

    move-result-object v1

    .line 238
    .local v1, "dataSource":Lcoil/decode/DataSource;
    iget-object v2, p0, Lcoil/RealImageLoader;->logger:Lcoil/util/Logger;

    if-eqz v2, :cond_1

    const-string v3, "RealImageLoader"

    .local v3, "tag$iv":Ljava/lang/String;
    const/4 v4, 0x4

    .local v2, "$this$log$iv":Lcoil/util/Logger;
    .local v4, "priority$iv":I
    const/4 v5, 0x0

    .line 322
    .local v5, "$i$f$log":I
    invoke-interface {v2}, Lcoil/util/Logger;->getLevel()I

    move-result v6

    if-gt v6, v4, :cond_0

    .line 323
    const/4 v6, 0x0

    .line 239
    .local v6, "$i$a$-log-RealImageLoader$onSuccess$1":I
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {v1}, Lcoil/util/-Utils;->getEmoji(Lcoil/decode/DataSource;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " Successful ("

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v1}, Lcoil/decode/DataSource;->name()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ") - "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v0}, Lcoil/request/ImageRequest;->getData()Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 323
    .end local v6    # "$i$a$-log-RealImageLoader$onSuccess$1":I
    const/4 v7, 0x0

    invoke-interface {v2, v3, v4, v6, v7}, Lcoil/util/Logger;->log(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V

    .line 325
    :cond_0
    nop

    .line 241
    .end local v2    # "$this$log$iv":Lcoil/util/Logger;
    .end local v3    # "tag$iv":Ljava/lang/String;
    .end local v4    # "priority$iv":I
    .end local v5    # "$i$f$log":I
    :cond_1
    move-object v2, p0

    .local v2, "this_$iv":Lcoil/RealImageLoader;
    const/4 v3, 0x0

    .line 326
    .local v3, "$i$f$transition":I
    instance-of v4, p2, Lcoil/transition/TransitionTarget;

    if-nez v4, :cond_3

    .line 327
    const/4 v4, 0x0

    .line 241
    .local v4, "$i$a$-transition-RealImageLoader$onSuccess$2":I
    if-eqz p2, :cond_2

    invoke-virtual {p1}, Lcoil/request/SuccessResult;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-interface {p2, v5}, Lcoil/target/Target;->onSuccess(Landroid/graphics/drawable/Drawable;)V

    .line 327
    .end local v4    # "$i$a$-transition-RealImageLoader$onSuccess$2":I
    :cond_2
    nop

    .line 328
    goto :goto_0

    .line 331
    :cond_3
    move-object v4, p1

    check-cast v4, Lcoil/request/ImageResult;

    invoke-virtual {v4}, Lcoil/request/ImageResult;->getRequest()Lcoil/request/ImageRequest;

    move-result-object v4

    invoke-virtual {v4}, Lcoil/request/ImageRequest;->getTransitionFactory()Lcoil/transition/Transition$Factory;

    move-result-object v4

    move-object v5, p2

    check-cast v5, Lcoil/transition/TransitionTarget;

    move-object v6, p1

    check-cast v6, Lcoil/request/ImageResult;

    invoke-interface {v4, v5, v6}, Lcoil/transition/Transition$Factory;->create(Lcoil/transition/TransitionTarget;Lcoil/request/ImageResult;)Lcoil/transition/Transition;

    move-result-object v4

    .line 332
    .local v4, "transition$iv":Lcoil/transition/Transition;
    instance-of v5, v4, Lcoil/transition/NoneTransition;

    if-eqz v5, :cond_4

    .line 333
    const/4 v5, 0x0

    .line 241
    .local v5, "$i$a$-transition-RealImageLoader$onSuccess$2":I
    invoke-virtual {p1}, Lcoil/request/SuccessResult;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v6

    invoke-interface {p2, v6}, Lcoil/target/Target;->onSuccess(Landroid/graphics/drawable/Drawable;)V

    .line 333
    .end local v5    # "$i$a$-transition-RealImageLoader$onSuccess$2":I
    nop

    .line 334
    goto :goto_0

    .line 337
    :cond_4
    move-object v5, p1

    check-cast v5, Lcoil/request/ImageResult;

    invoke-virtual {v5}, Lcoil/request/ImageResult;->getRequest()Lcoil/request/ImageRequest;

    move-result-object v5

    invoke-interface {p3, v5, v4}, Lcoil/EventListener;->transitionStart(Lcoil/request/ImageRequest;Lcoil/transition/Transition;)V

    .line 338
    invoke-interface {v4}, Lcoil/transition/Transition;->transition()V

    .line 339
    move-object v5, p1

    check-cast v5, Lcoil/request/ImageResult;

    invoke-virtual {v5}, Lcoil/request/ImageResult;->getRequest()Lcoil/request/ImageRequest;

    move-result-object v5

    invoke-interface {p3, v5, v4}, Lcoil/EventListener;->transitionEnd(Lcoil/request/ImageRequest;Lcoil/transition/Transition;)V

    .line 340
    nop

    .line 242
    .end local v2    # "this_$iv":Lcoil/RealImageLoader;
    .end local v3    # "$i$f$transition":I
    .end local v4    # "transition$iv":Lcoil/transition/Transition;
    :goto_0
    invoke-interface {p3, v0, p1}, Lcoil/EventListener;->onSuccess(Lcoil/request/ImageRequest;Lcoil/request/SuccessResult;)V

    .line 243
    invoke-virtual {v0}, Lcoil/request/ImageRequest;->getListener()Lcoil/request/ImageRequest$Listener;

    move-result-object v2

    if-eqz v2, :cond_5

    invoke-interface {v2, v0, p1}, Lcoil/request/ImageRequest$Listener;->onSuccess(Lcoil/request/ImageRequest;Lcoil/request/SuccessResult;)V

    .line 244
    :cond_5
    return-void
.end method

.method private final transition(Lcoil/request/ImageResult;Lcoil/target/Target;Lcoil/EventListener;Lkotlin/jvm/functions/Function0;)V
    .locals 3
    .param p1, "result"    # Lcoil/request/ImageResult;
    .param p2, "target"    # Lcoil/target/Target;
    .param p3, "eventListener"    # Lcoil/EventListener;
    .param p4, "setDrawable"    # Lkotlin/jvm/functions/Function0;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcoil/request/ImageResult;",
            "Lcoil/target/Target;",
            "Lcoil/EventListener;",
            "Lkotlin/jvm/functions/Function0<",
            "Lkotlin/Unit;",
            ">;)V"
        }
    .end annotation

    const/4 v0, 0x0

    .line 274
    .local v0, "$i$f$transition":I
    instance-of v1, p2, Lcoil/transition/TransitionTarget;

    if-nez v1, :cond_0

    .line 275
    invoke-interface {p4}, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;

    .line 276
    return-void

    .line 279
    :cond_0
    invoke-virtual {p1}, Lcoil/request/ImageResult;->getRequest()Lcoil/request/ImageRequest;

    move-result-object v1

    invoke-virtual {v1}, Lcoil/request/ImageRequest;->getTransitionFactory()Lcoil/transition/Transition$Factory;

    move-result-object v1

    move-object v2, p2

    check-cast v2, Lcoil/transition/TransitionTarget;

    invoke-interface {v1, v2, p1}, Lcoil/transition/Transition$Factory;->create(Lcoil/transition/TransitionTarget;Lcoil/request/ImageResult;)Lcoil/transition/Transition;

    move-result-object v1

    .line 280
    .local v1, "transition":Lcoil/transition/Transition;
    instance-of v2, v1, Lcoil/transition/NoneTransition;

    if-eqz v2, :cond_1

    .line 281
    invoke-interface {p4}, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;

    .line 282
    return-void

    .line 285
    :cond_1
    invoke-virtual {p1}, Lcoil/request/ImageResult;->getRequest()Lcoil/request/ImageRequest;

    move-result-object v2

    invoke-interface {p3, v2, v1}, Lcoil/EventListener;->transitionStart(Lcoil/request/ImageRequest;Lcoil/transition/Transition;)V

    .line 286
    invoke-interface {v1}, Lcoil/transition/Transition;->transition()V

    .line 287
    invoke-virtual {p1}, Lcoil/request/ImageResult;->getRequest()Lcoil/request/ImageRequest;

    move-result-object v2

    invoke-interface {p3, v2, v1}, Lcoil/EventListener;->transitionEnd(Lcoil/request/ImageRequest;Lcoil/transition/Transition;)V

    .line 288
    return-void
.end method


# virtual methods
.method public enqueue(Lcoil/request/ImageRequest;)Lcoil/request/Disposable;
    .locals 6
    .param p1, "request"    # Lcoil/request/ImageRequest;

    .line 116
    iget-object v0, p0, Lcoil/RealImageLoader;->scope:Lkotlinx/coroutines/CoroutineScope;

    const/4 v1, 0x0

    const/4 v2, 0x0

    new-instance v3, Lcoil/RealImageLoader$enqueue$job$1;

    const/4 v4, 0x0

    invoke-direct {v3, p0, p1, v4}, Lcoil/RealImageLoader$enqueue$job$1;-><init>(Lcoil/RealImageLoader;Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)V

    check-cast v3, Lkotlin/jvm/functions/Function2;

    const/4 v4, 0x3

    const/4 v5, 0x0

    invoke-static/range {v0 .. v5}, Lkotlinx/coroutines/BuildersKt;->async$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Deferred;

    move-result-object v0

    .line 123
    .local v0, "job":Lkotlinx/coroutines/Deferred;
    invoke-virtual {p1}, Lcoil/request/ImageRequest;->getTarget()Lcoil/target/Target;

    move-result-object v1

    instance-of v1, v1, Lcoil/target/ViewTarget;

    if-eqz v1, :cond_0

    .line 124
    invoke-virtual {p1}, Lcoil/request/ImageRequest;->getTarget()Lcoil/target/Target;

    move-result-object v1

    check-cast v1, Lcoil/target/ViewTarget;

    invoke-interface {v1}, Lcoil/target/ViewTarget;->getView()Landroid/view/View;

    move-result-object v1

    invoke-static {v1}, Lcoil/util/-Utils;->getRequestManager(Landroid/view/View;)Lcoil/request/ViewTargetRequestManager;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcoil/request/ViewTargetRequestManager;->getDisposable(Lkotlinx/coroutines/Deferred;)Lcoil/request/ViewTargetDisposable;

    move-result-object v1

    check-cast v1, Lcoil/request/Disposable;

    goto :goto_0

    .line 126
    :cond_0
    new-instance v1, Lcoil/request/OneShotDisposable;

    invoke-direct {v1, v0}, Lcoil/request/OneShotDisposable;-><init>(Lkotlinx/coroutines/Deferred;)V

    check-cast v1, Lcoil/request/Disposable;

    .line 123
    :goto_0
    return-object v1
.end method

.method public execute(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 2
    .param p1, "request"    # Lcoil/request/ImageRequest;
    .param p2, "$completion"    # Lkotlin/coroutines/Continuation;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcoil/request/ImageRequest;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lcoil/request/ImageResult;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    .line 130
    new-instance v0, Lcoil/RealImageLoader$execute$2;

    const/4 v1, 0x0

    invoke-direct {v0, p1, p0, v1}, Lcoil/RealImageLoader$execute$2;-><init>(Lcoil/request/ImageRequest;Lcoil/RealImageLoader;Lkotlin/coroutines/Continuation;)V

    check-cast v0, Lkotlin/jvm/functions/Function2;

    invoke-static {v0, p2}, Lkotlinx/coroutines/CoroutineScopeKt;->coroutineScope(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v0

    .line 141
    return-object v0
.end method

.method public final getCallFactoryLazy()Lkotlin/Lazy;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lkotlin/Lazy<",
            "Lokhttp3/Call$Factory;",
            ">;"
        }
    .end annotation

    .line 70
    iget-object v0, p0, Lcoil/RealImageLoader;->callFactoryLazy:Lkotlin/Lazy;

    return-object v0
.end method

.method public final getComponentRegistry()Lcoil/ComponentRegistry;
    .locals 1

    .line 72
    iget-object v0, p0, Lcoil/RealImageLoader;->componentRegistry:Lcoil/ComponentRegistry;

    return-object v0
.end method

.method public getComponents()Lcoil/ComponentRegistry;
    .locals 1

    .line 83
    iget-object v0, p0, Lcoil/RealImageLoader;->components:Lcoil/ComponentRegistry;

    return-object v0
.end method

.method public final getContext()Landroid/content/Context;
    .locals 1

    .line 66
    iget-object v0, p0, Lcoil/RealImageLoader;->context:Landroid/content/Context;

    return-object v0
.end method

.method public getDefaults()Lcoil/request/DefaultRequestOptions;
    .locals 1

    .line 67
    iget-object v0, p0, Lcoil/RealImageLoader;->defaults:Lcoil/request/DefaultRequestOptions;

    return-object v0
.end method

.method public getDiskCache()Lcoil/disk/DiskCache;
    .locals 1

    .line 82
    iget-object v0, p0, Lcoil/RealImageLoader;->diskCacheLazy:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcoil/disk/DiskCache;

    return-object v0
.end method

.method public final getDiskCacheLazy()Lkotlin/Lazy;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lkotlin/Lazy<",
            "Lcoil/disk/DiskCache;",
            ">;"
        }
    .end annotation

    .line 69
    iget-object v0, p0, Lcoil/RealImageLoader;->diskCacheLazy:Lkotlin/Lazy;

    return-object v0
.end method

.method public final getEventListenerFactory()Lcoil/EventListener$Factory;
    .locals 1

    .line 71
    iget-object v0, p0, Lcoil/RealImageLoader;->eventListenerFactory:Lcoil/EventListener$Factory;

    return-object v0
.end method

.method public final getLogger()Lcoil/util/Logger;
    .locals 1

    .line 74
    iget-object v0, p0, Lcoil/RealImageLoader;->logger:Lcoil/util/Logger;

    return-object v0
.end method

.method public getMemoryCache()Lcoil/memory/MemoryCache;
    .locals 1

    .line 81
    iget-object v0, p0, Lcoil/RealImageLoader;->memoryCacheLazy:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcoil/memory/MemoryCache;

    return-object v0
.end method

.method public final getMemoryCacheLazy()Lkotlin/Lazy;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lkotlin/Lazy<",
            "Lcoil/memory/MemoryCache;",
            ">;"
        }
    .end annotation

    .line 68
    iget-object v0, p0, Lcoil/RealImageLoader;->memoryCacheLazy:Lkotlin/Lazy;

    return-object v0
.end method

.method public final getOptions()Lcoil/util/ImageLoaderOptions;
    .locals 1

    .line 73
    iget-object v0, p0, Lcoil/RealImageLoader;->options:Lcoil/util/ImageLoaderOptions;

    return-object v0
.end method

.method public newBuilder()Lcoil/ImageLoader$Builder;
    .locals 1

    .line 229
    new-instance v0, Lcoil/ImageLoader$Builder;

    invoke-direct {v0, p0}, Lcoil/ImageLoader$Builder;-><init>(Lcoil/RealImageLoader;)V

    return-object v0
.end method

.method public final onTrimMemory$coil_base_release(I)V
    .locals 1
    .param p1, "level"    # I

    .line 219
    iget-object v0, p0, Lcoil/RealImageLoader;->memoryCacheLazy:Lkotlin/Lazy;

    if-eqz v0, :cond_0

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcoil/memory/MemoryCache;

    if-eqz v0, :cond_0

    invoke-interface {v0, p1}, Lcoil/memory/MemoryCache;->trimMemory(I)V

    .line 220
    :cond_0
    return-void
.end method

.method public shutdown()V
    .locals 3

    .line 223
    iget-object v0, p0, Lcoil/RealImageLoader;->shutdown:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z

    move-result v0

    if-eqz v0, :cond_0

    return-void

    .line 224
    :cond_0
    iget-object v0, p0, Lcoil/RealImageLoader;->scope:Lkotlinx/coroutines/CoroutineScope;

    const/4 v2, 0x0

    invoke-static {v0, v2, v1, v2}, Lkotlinx/coroutines/CoroutineScopeKt;->cancel$default(Lkotlinx/coroutines/CoroutineScope;Ljava/util/concurrent/CancellationException;ILjava/lang/Object;)V

    .line 225
    iget-object v0, p0, Lcoil/RealImageLoader;->systemCallbacks:Lcoil/util/SystemCallbacks;

    invoke-virtual {v0}, Lcoil/util/SystemCallbacks;->shutdown()V

    .line 226
    invoke-virtual {p0}, Lcoil/RealImageLoader;->getMemoryCache()Lcoil/memory/MemoryCache;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-interface {v0}, Lcoil/memory/MemoryCache;->clear()V

    .line 227
    :cond_1
    return-void
.end method
