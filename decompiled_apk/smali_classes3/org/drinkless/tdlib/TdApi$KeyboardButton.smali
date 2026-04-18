.class public Lorg/drinkless/tdlib/TdApi$KeyboardButton;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "KeyboardButton"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7b5f318c


# instance fields
.field public text:Ljava/lang/String;

.field public type:Lorg/drinkless/tdlib/TdApi$KeyboardButtonType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27904
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27905
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$KeyboardButtonType;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "keyboardButtonType"    # Lorg/drinkless/tdlib/TdApi$KeyboardButtonType;

    .line 27894
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27895
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButton;->text:Ljava/lang/String;

    .line 27896
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButton;->type:Lorg/drinkless/tdlib/TdApi$KeyboardButtonType;

    .line 27897
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27901
    const v0, -0x7b5f318c

    return v0
.end method
