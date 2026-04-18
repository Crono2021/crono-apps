.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeBusinessChat;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeBusinessChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5fc51629


# instance fields
.field public linkName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15252
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15253
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 15243
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15244
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeBusinessChat;->linkName:Ljava/lang/String;

    .line 15245
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15249
    const v0, -0x5fc51629

    return v0
.end method
