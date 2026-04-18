.class public Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InlineKeyboardButton"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x162de1e8


# instance fields
.field public text:Ljava/lang/String;

.field public type:Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27084
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27085
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "inlineKeyboardButtonType"    # Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;

    .line 27074
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27075
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;->text:Ljava/lang/String;

    .line 27076
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;->type:Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;

    .line 27077
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27081
    const v0, -0x162de1e8

    return v0
.end method
