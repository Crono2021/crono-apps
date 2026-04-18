.class public final Lcoil/util/SystemCallbacks;
.super Ljava/lang/Object;
.source "SystemCallbacks.kt"

# interfaces
.implements Landroid/content/ComponentCallbacks2;
.implements Lcoil/network/NetworkObserver$Listener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcoil/util/SystemCallbacks$Companion;
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nSystemCallbacks.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SystemCallbacks.kt\ncoil/util/SystemCallbacks\n+ 2 Logs.kt\ncoil/util/-Logs\n*L\n1#1,78:1\n69#1:79\n70#1:84\n69#1:85\n70#1:90\n21#2,4:80\n21#2,4:86\n*S KotlinDebug\n*F\n+ 1 SystemCallbacks.kt\ncoil/util/SystemCallbacks\n*L\n50#1:79\n50#1:84\n57#1:85\n57#1:90\n51#1:80,4\n58#1:86,4\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0008H\u0016J\u0008\u0010\u001d\u001a\u00020\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0006\u0010!\u001a\u00020\u0019J\u0006\u0010\"\u001a\u00020\u0019J\u001d\u0010#\u001a\u00020\u00192\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190%H\u0082\u0008R\u000e\u0010\n\u001a\u00020\u0008X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u0003\u001a\u0010\u0012\u000c\u0012\n \u000e*\u0004\u0018\u00010\u00040\u00040\r8\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00088F\u00a2\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00088F\u00a2\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"
    }
    d2 = {
        "Lcoil/util/SystemCallbacks;",
        "Landroid/content/ComponentCallbacks2;",
        "Lcoil/network/NetworkObserver$Listener;",
        "imageLoader",
        "Lcoil/RealImageLoader;",
        "context",
        "Landroid/content/Context;",
        "isNetworkObserverEnabled",
        "",
        "(Lcoil/RealImageLoader;Landroid/content/Context;Z)V",
        "_isOnline",
        "_isShutdown",
        "Ljava/util/concurrent/atomic/AtomicBoolean;",
        "Ljava/lang/ref/WeakReference;",
        "kotlin.jvm.PlatformType",
        "getImageLoader$coil_base_release$annotations",
        "()V",
        "getImageLoader$coil_base_release",
        "()Ljava/lang/ref/WeakReference;",
        "isOnline",
        "()Z",
        "isShutdown",
        "networkObserver",
        "Lcoil/network/NetworkObserver;",
        "onConfigurationChanged",
        "",
        "newConfig",
        "Landroid/content/res/Configuration;",
        "onConnectivityChange",
        "onLowMemory",
        "onTrimMemory",
        "level",
        "",
        "register",
        "shutdown",
        "withImageLoader",
        "block",
        "Lkotlin/Function1;",
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
.field public static final Companion:Lcoil/util/SystemCallbacks$Companion;

.field private static final OFFLINE:Ljava/lang/String; = "OFFLINE"

.field private static final ONLINE:Ljava/lang/String; = "ONLINE"

.field private static final TAG:Ljava/lang/String; = "NetworkObserver"


# instance fields
.field private volatile _isOnline:Z

.field private final _isShutdown:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private final context:Landroid/content/Context;

.field private final imageLoader:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference<",
            "Lcoil/RealImageLoader;",
            ">;"
        }
    .end annotation
.end field

.field private final networkObserver:Lcoil/network/NetworkObserver;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lcoil/util/SystemCallbacks$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcoil/util/SystemCallbacks$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lcoil/util/SystemCallbacks;->Companion:Lcoil/util/SystemCallbacks$Companion;

    return-void
.end method

.method public constructor <init>(Lcoil/RealImageLoader;Landroid/content/Context;Z)V
    .locals 2
    .param p1, "imageLoader"    # Lcoil/RealImageLoader;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "isNetworkObserverEnabled"    # Z

    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p2, p0, Lcoil/util/SystemCallbacks;->context:Landroid/content/Context;

    .line 29
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcoil/util/SystemCallbacks;->imageLoader:Ljava/lang/ref/WeakReference;

    .line 30
    if-eqz p3, :cond_0

    .line 31
    move-object v0, p0

    check-cast v0, Lcoil/network/NetworkObserver$Listener;

    invoke-virtual {p1}, Lcoil/RealImageLoader;->getLogger()Lcoil/util/Logger;

    move-result-object v1

    invoke-static {p2, v0, v1}, Lcoil/network/NetworkObserverKt;->NetworkObserver(Landroid/content/Context;Lcoil/network/NetworkObserver$Listener;Lcoil/util/Logger;)Lcoil/network/NetworkObserver;

    move-result-object v0

    goto :goto_0

    .line 33
    :cond_0
    new-instance v0, Lcoil/network/EmptyNetworkObserver;

    invoke-direct {v0}, Lcoil/network/EmptyNetworkObserver;-><init>()V

    check-cast v0, Lcoil/network/NetworkObserver;

    .line 30
    :goto_0
    iput-object v0, p0, Lcoil/util/SystemCallbacks;->networkObserver:Lcoil/network/NetworkObserver;

    .line 36
    invoke-interface {v0}, Lcoil/network/NetworkObserver;->isOnline()Z

    move-result v0

    iput-boolean v0, p0, Lcoil/util/SystemCallbacks;->_isOnline:Z

    .line 37
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcoil/util/SystemCallbacks;->_isShutdown:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 23
    return-void
.end method

.method public static synthetic getImageLoader$coil_base_release$annotations()V
    .locals 0

    return-void
.end method

.method private final withImageLoader(Lkotlin/jvm/functions/Function1;)V
    .locals 2
    .param p1, "block"    # Lkotlin/jvm/functions/Function1;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function1<",
            "-",
            "Lcoil/RealImageLoader;",
            "Lkotlin/Unit;",
            ">;)V"
        }
    .end annotation

    const/4 v0, 0x0

    .line 69
    .local v0, "$i$f$withImageLoader":I
    iget-object v1, p0, Lcoil/util/SystemCallbacks;->imageLoader:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcoil/RealImageLoader;

    if-eqz v1, :cond_0

    invoke-interface {p1, v1}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    if-nez v1, :cond_1

    invoke-virtual {p0}, Lcoil/util/SystemCallbacks;->shutdown()V

    .line 70
    :cond_1
    return-void
.end method


# virtual methods
.method public final getImageLoader$coil_base_release()Ljava/lang/ref/WeakReference;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/ref/WeakReference<",
            "Lcoil/RealImageLoader;",
            ">;"
        }
    .end annotation

    .line 29
    iget-object v0, p0, Lcoil/util/SystemCallbacks;->imageLoader:Ljava/lang/ref/WeakReference;

    return-object v0
.end method

.method public final isOnline()Z
    .locals 1

    .line 39
    iget-boolean v0, p0, Lcoil/util/SystemCallbacks;->_isOnline:Z

    return v0
.end method

.method public final isShutdown()Z
    .locals 1

    .line 40
    iget-object v0, p0, Lcoil/util/SystemCallbacks;->_isShutdown:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    return v0
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 1
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .line 47
    iget-object v0, p0, Lcoil/util/SystemCallbacks;->imageLoader:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcoil/RealImageLoader;

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcoil/util/SystemCallbacks;->shutdown()V

    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    .line 48
    :cond_0
    return-void
.end method

.method public onConnectivityChange(Z)V
    .locals 11
    .param p1, "isOnline"    # Z

    .line 57
    move-object v0, p0

    .local v0, "this_$iv":Lcoil/util/SystemCallbacks;
    const/4 v1, 0x0

    .line 85
    .local v1, "$i$f$withImageLoader":I
    iget-object v2, v0, Lcoil/util/SystemCallbacks;->imageLoader:Ljava/lang/ref/WeakReference;

    invoke-virtual {v2}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcoil/RealImageLoader;

    const/4 v3, 0x0

    if-eqz v2, :cond_3

    .local v2, "imageLoader":Lcoil/RealImageLoader;
    const/4 v4, 0x0

    .line 58
    .local v4, "$i$a$-withImageLoader-SystemCallbacks$onConnectivityChange$1":I
    invoke-virtual {v2}, Lcoil/RealImageLoader;->getLogger()Lcoil/util/Logger;

    move-result-object v5

    if-eqz v5, :cond_2

    const-string v6, "NetworkObserver"

    .local v6, "tag$iv":Ljava/lang/String;
    const/4 v7, 0x4

    .local v5, "$this$log$iv":Lcoil/util/Logger;
    .local v7, "priority$iv":I
    const/4 v8, 0x0

    .line 86
    .local v8, "$i$f$log":I
    invoke-interface {v5}, Lcoil/util/Logger;->getLevel()I

    move-result v9

    if-gt v9, v7, :cond_1

    .line 87
    const/4 v9, 0x0

    .line 58
    .local v9, "$i$a$-log-SystemCallbacks$onConnectivityChange$1$1":I
    if-eqz p1, :cond_0

    const-string v10, "ONLINE"

    goto :goto_0

    :cond_0
    const-string v10, "OFFLINE"

    .line 87
    .end local v9    # "$i$a$-log-SystemCallbacks$onConnectivityChange$1$1":I
    :goto_0
    invoke-interface {v5, v6, v7, v10, v3}, Lcoil/util/Logger;->log(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V

    .line 89
    :cond_1
    nop

    .line 59
    .end local v5    # "$this$log$iv":Lcoil/util/Logger;
    .end local v6    # "tag$iv":Ljava/lang/String;
    .end local v7    # "priority$iv":I
    .end local v8    # "$i$f$log":I
    :cond_2
    iput-boolean p1, p0, Lcoil/util/SystemCallbacks;->_isOnline:Z

    .line 60
    nop

    .line 85
    .end local v2    # "imageLoader":Lcoil/RealImageLoader;
    .end local v4    # "$i$a$-withImageLoader-SystemCallbacks$onConnectivityChange$1":I
    sget-object v3, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    :cond_3
    if-nez v3, :cond_4

    invoke-virtual {v0}, Lcoil/util/SystemCallbacks;->shutdown()V

    .line 90
    :cond_4
    nop

    .line 60
    .end local v0    # "this_$iv":Lcoil/util/SystemCallbacks;
    .end local v1    # "$i$f$withImageLoader":I
    return-void
.end method

.method public onLowMemory()V
    .locals 1

    .line 55
    const/16 v0, 0x50

    invoke-virtual {p0, v0}, Lcoil/util/SystemCallbacks;->onTrimMemory(I)V

    return-void
.end method

.method public onTrimMemory(I)V
    .locals 12
    .param p1, "level"    # I

    .line 50
    move-object v0, p0

    .local v0, "this_$iv":Lcoil/util/SystemCallbacks;
    const/4 v1, 0x0

    .line 79
    .local v1, "$i$f$withImageLoader":I
    iget-object v2, v0, Lcoil/util/SystemCallbacks;->imageLoader:Ljava/lang/ref/WeakReference;

    invoke-virtual {v2}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcoil/RealImageLoader;

    const/4 v3, 0x0

    if-eqz v2, :cond_2

    .local v2, "imageLoader":Lcoil/RealImageLoader;
    const/4 v4, 0x0

    .line 51
    .local v4, "$i$a$-withImageLoader-SystemCallbacks$onTrimMemory$1":I
    invoke-virtual {v2}, Lcoil/RealImageLoader;->getLogger()Lcoil/util/Logger;

    move-result-object v5

    if-eqz v5, :cond_1

    const-string v6, "NetworkObserver"

    .local v6, "tag$iv":Ljava/lang/String;
    const/4 v7, 0x2

    .local v5, "$this$log$iv":Lcoil/util/Logger;
    .local v7, "priority$iv":I
    const/4 v8, 0x0

    .line 80
    .local v8, "$i$f$log":I
    invoke-interface {v5}, Lcoil/util/Logger;->getLevel()I

    move-result v9

    if-gt v9, v7, :cond_0

    .line 81
    const/4 v9, 0x0

    .line 51
    .local v9, "$i$a$-log-SystemCallbacks$onTrimMemory$1$1":I
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "trimMemory, level="

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 81
    .end local v9    # "$i$a$-log-SystemCallbacks$onTrimMemory$1$1":I
    invoke-interface {v5, v6, v7, v9, v3}, Lcoil/util/Logger;->log(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V

    .line 83
    :cond_0
    nop

    .line 52
    .end local v5    # "$this$log$iv":Lcoil/util/Logger;
    .end local v6    # "tag$iv":Ljava/lang/String;
    .end local v7    # "priority$iv":I
    .end local v8    # "$i$f$log":I
    :cond_1
    invoke-virtual {v2, p1}, Lcoil/RealImageLoader;->onTrimMemory$coil_base_release(I)V

    .line 53
    nop

    .line 79
    .end local v2    # "imageLoader":Lcoil/RealImageLoader;
    .end local v4    # "$i$a$-withImageLoader-SystemCallbacks$onTrimMemory$1":I
    sget-object v3, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    :cond_2
    if-nez v3, :cond_3

    invoke-virtual {v0}, Lcoil/util/SystemCallbacks;->shutdown()V

    .line 84
    :cond_3
    nop

    .line 53
    .end local v0    # "this_$iv":Lcoil/util/SystemCallbacks;
    .end local v1    # "$i$f$withImageLoader":I
    return-void
.end method

.method public final register()V
    .locals 2

    .line 43
    iget-object v0, p0, Lcoil/util/SystemCallbacks;->context:Landroid/content/Context;

    move-object v1, p0

    check-cast v1, Landroid/content/ComponentCallbacks;

    invoke-virtual {v0, v1}, Landroid/content/Context;->registerComponentCallbacks(Landroid/content/ComponentCallbacks;)V

    .line 44
    return-void
.end method

.method public final shutdown()V
    .locals 2

    .line 63
    iget-object v0, p0, Lcoil/util/SystemCallbacks;->_isShutdown:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z

    move-result v0

    if-eqz v0, :cond_0

    return-void

    .line 64
    :cond_0
    iget-object v0, p0, Lcoil/util/SystemCallbacks;->context:Landroid/content/Context;

    move-object v1, p0

    check-cast v1, Landroid/content/ComponentCallbacks;

    invoke-virtual {v0, v1}, Landroid/content/Context;->unregisterComponentCallbacks(Landroid/content/ComponentCallbacks;)V

    .line 65
    iget-object v0, p0, Lcoil/util/SystemCallbacks;->networkObserver:Lcoil/network/NetworkObserver;

    invoke-interface {v0}, Lcoil/network/NetworkObserver;->shutdown()V

    .line 66
    return-void
.end method
