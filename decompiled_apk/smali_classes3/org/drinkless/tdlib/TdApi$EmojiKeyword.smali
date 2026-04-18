.class public Lorg/drinkless/tdlib/TdApi$EmojiKeyword;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EmojiKeyword"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7de6ed21


# instance fields
.field public emoji:Ljava/lang/String;

.field public keyword:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25424
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 25425
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 25414
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 25415
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EmojiKeyword;->emoji:Ljava/lang/String;

    .line 25416
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$EmojiKeyword;->keyword:Ljava/lang/String;

    .line 25417
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25421
    const v0, -0x7de6ed21

    return v0
.end method
