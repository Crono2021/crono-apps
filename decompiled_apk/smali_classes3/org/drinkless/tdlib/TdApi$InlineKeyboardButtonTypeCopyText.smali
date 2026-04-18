.class public Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonTypeCopyText;
.super Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InlineKeyboardButtonTypeCopyText"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x41b1306


# instance fields
.field public text:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14316
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;-><init>()V

    .line 14317
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 14307
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;-><init>()V

    .line 14308
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonTypeCopyText;->text:Ljava/lang/String;

    .line 14309
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14313
    const v0, 0x41b1306

    return v0
.end method
