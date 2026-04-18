.class public Lorg/drinkless/tdlib/TdApi$InlineQueryResultsButton;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InlineQueryResultsButton"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2f20f752


# instance fields
.field public text:Ljava/lang/String;

.field public type:Lorg/drinkless/tdlib/TdApi$InlineQueryResultsButtonType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27184
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27185
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$InlineQueryResultsButtonType;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "inlineQueryResultsButtonType"    # Lorg/drinkless/tdlib/TdApi$InlineQueryResultsButtonType;

    .line 27174
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27175
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultsButton;->text:Ljava/lang/String;

    .line 27176
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultsButton;->type:Lorg/drinkless/tdlib/TdApi$InlineQueryResultsButtonType;

    .line 27177
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27181
    const v0, -0x2f20f752

    return v0
.end method
