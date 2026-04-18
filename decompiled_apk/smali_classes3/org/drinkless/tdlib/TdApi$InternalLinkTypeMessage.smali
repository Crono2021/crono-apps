.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeMessage;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeMessage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3a535c52


# instance fields
.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15396
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15397
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 15387
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15388
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeMessage;->url:Ljava/lang/String;

    .line 15389
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15393
    const v0, 0x3a535c52

    return v0
.end method
