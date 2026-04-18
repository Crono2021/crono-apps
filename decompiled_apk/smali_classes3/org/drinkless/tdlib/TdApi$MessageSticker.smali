.class public Lorg/drinkless/tdlib/TdApi$MessageSticker;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageSticker"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1a0f2336


# instance fields
.field public isPremium:Z

.field public sticker:Lorg/drinkless/tdlib/TdApi$Sticker;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28644
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28645
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Sticker;Z)V
    .locals 0
    .param p1, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;
    .param p2, "z8"    # Z

    .line 28634
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28635
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageSticker;->sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 28636
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$MessageSticker;->isPremium:Z

    .line 28637
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28641
    const v0, -0x1a0f2336

    return v0
.end method
