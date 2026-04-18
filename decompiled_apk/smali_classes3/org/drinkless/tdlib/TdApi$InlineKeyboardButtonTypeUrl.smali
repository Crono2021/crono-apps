.class public Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonTypeUrl;
.super Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InlineKeyboardButtonTypeUrl"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4365beac


# instance fields
.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14334
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;-><init>()V

    .line 14335
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 14325
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;-><init>()V

    .line 14326
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonTypeUrl;->url:Ljava/lang/String;

    .line 14327
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14331
    const v0, 0x4365beac

    return v0
.end method
