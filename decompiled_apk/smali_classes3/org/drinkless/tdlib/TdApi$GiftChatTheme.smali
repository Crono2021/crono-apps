.class public Lorg/drinkless/tdlib/TdApi$GiftChatTheme;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GiftChatTheme"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x25aab5e3


# instance fields
.field public darkSettings:Lorg/drinkless/tdlib/TdApi$ThemeSettings;

.field public gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;

.field public lightSettings:Lorg/drinkless/tdlib/TdApi$ThemeSettings;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37688
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 37689
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$UpgradedGift;Lorg/drinkless/tdlib/TdApi$ThemeSettings;Lorg/drinkless/tdlib/TdApi$ThemeSettings;)V
    .locals 0
    .param p1, "upgradedGift"    # Lorg/drinkless/tdlib/TdApi$UpgradedGift;
    .param p2, "themeSettings"    # Lorg/drinkless/tdlib/TdApi$ThemeSettings;
    .param p3, "themeSettings2"    # Lorg/drinkless/tdlib/TdApi$ThemeSettings;

    .line 37677
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 37678
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GiftChatTheme;->gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;

    .line 37679
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GiftChatTheme;->lightSettings:Lorg/drinkless/tdlib/TdApi$ThemeSettings;

    .line 37680
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GiftChatTheme;->darkSettings:Lorg/drinkless/tdlib/TdApi$ThemeSettings;

    .line 37681
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37685
    const v0, 0x25aab5e3

    return v0
.end method
