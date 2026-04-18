.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypePremiumGift;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypePremiumGift"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5ad56d41


# instance fields
.field public referrer:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15432
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15433
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 15423
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15424
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypePremiumGift;->referrer:Ljava/lang/String;

    .line 15425
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15429
    const v0, 0x5ad56d41

    return v0
.end method
