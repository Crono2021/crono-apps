.class public Lorg/drinkless/tdlib/TdApi$ProfileAccentColor;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ProfileAccentColor"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x213d8295


# instance fields
.field public darkThemeColors:Lorg/drinkless/tdlib/TdApi$ProfileAccentColors;

.field public id:I

.field public lightThemeColors:Lorg/drinkless/tdlib/TdApi$ProfileAccentColors;

.field public minChannelChatBoostLevel:I

.field public minSupergroupChatBoostLevel:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48424
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48425
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$ProfileAccentColors;Lorg/drinkless/tdlib/TdApi$ProfileAccentColors;II)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "profileAccentColors"    # Lorg/drinkless/tdlib/TdApi$ProfileAccentColors;
    .param p3, "profileAccentColors2"    # Lorg/drinkless/tdlib/TdApi$ProfileAccentColors;
    .param p4, "i10"    # I
    .param p5, "i11"    # I

    .line 48411
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48412
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ProfileAccentColor;->id:I

    .line 48413
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ProfileAccentColor;->lightThemeColors:Lorg/drinkless/tdlib/TdApi$ProfileAccentColors;

    .line 48414
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ProfileAccentColor;->darkThemeColors:Lorg/drinkless/tdlib/TdApi$ProfileAccentColors;

    .line 48415
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$ProfileAccentColor;->minSupergroupChatBoostLevel:I

    .line 48416
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$ProfileAccentColor;->minChannelChatBoostLevel:I

    .line 48417
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48421
    const v0, 0x213d8295

    return v0
.end method
