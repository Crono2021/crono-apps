.class public Lorg/drinkless/tdlib/TdApi$RemoveRecentHashtag;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RemoveRecentHashtag"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3c6c5f5c


# instance fields
.field public hashtag:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18546
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18547
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 18537
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18538
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RemoveRecentHashtag;->hashtag:Ljava/lang/String;

    .line 18539
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18543
    const v0, -0x3c6c5f5c

    return v0
.end method
