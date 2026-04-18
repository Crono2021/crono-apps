.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeChatBoost;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeChatBoost"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2ab602c0


# instance fields
.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15270
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15271
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 15261
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15262
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeChatBoost;->url:Ljava/lang/String;

    .line 15263
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15267
    const v0, -0x2ab602c0

    return v0
.end method
