.class public Lorg/drinkless/tdlib/TdApi$RtmpUrl;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RtmpUrl"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3c28bc55


# instance fields
.field public streamKey:Ljava/lang/String;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30468
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 30469
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 30458
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 30459
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RtmpUrl;->url:Ljava/lang/String;

    .line 30460
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$RtmpUrl;->streamKey:Ljava/lang/String;

    .line 30461
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30465
    const v0, 0x3c28bc55

    return v0
.end method
