.class public Lorg/drinkless/tdlib/TdApi$SentWebAppMessage;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SentWebAppMessage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4a24eec0


# instance fields
.field public inlineMessageId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19356
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 19357
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 19347
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 19348
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SentWebAppMessage;->inlineMessageId:Ljava/lang/String;

    .line 19349
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19353
    const v0, 0x4a24eec0    # 2702256.0f

    return v0
.end method
