.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypePremiumFeatures;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypePremiumFeatures"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x48884f49


# instance fields
.field public referrer:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15414
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15415
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 15405
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15406
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypePremiumFeatures;->referrer:Ljava/lang/String;

    .line 15407
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15411
    const v0, 0x48884f49

    return v0
.end method
