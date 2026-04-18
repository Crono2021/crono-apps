.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeBuyStars;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeBuyStars"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x56b33cb9


# instance fields
.field public purpose:Ljava/lang/String;

.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27624
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 27625
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 27614
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 27615
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeBuyStars;->starCount:J

    .line 27616
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeBuyStars;->purpose:Ljava/lang/String;

    .line 27617
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27621
    const v0, -0x56b33cb9

    return v0
.end method
