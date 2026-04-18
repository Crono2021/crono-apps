.class public Lorg/drinkless/tdlib/TdApi$ChatThemeGift;
.super Lorg/drinkless/tdlib/TdApi$ChatTheme;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatThemeGift"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x12d0839


# instance fields
.field public giftTheme:Lorg/drinkless/tdlib/TdApi$GiftChatTheme;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10428
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatTheme;-><init>()V

    .line 10429
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$GiftChatTheme;)V
    .locals 0
    .param p1, "giftChatTheme"    # Lorg/drinkless/tdlib/TdApi$GiftChatTheme;

    .line 10419
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatTheme;-><init>()V

    .line 10420
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatThemeGift;->giftTheme:Lorg/drinkless/tdlib/TdApi$GiftChatTheme;

    .line 10421
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10425
    const v0, 0x12d0839

    return v0
.end method
