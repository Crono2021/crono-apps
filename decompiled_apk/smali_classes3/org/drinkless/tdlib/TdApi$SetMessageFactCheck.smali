.class public Lorg/drinkless/tdlib/TdApi$SetMessageFactCheck;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetMessageFactCheck"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x41c2f8


# instance fields
.field public chatId:J

.field public messageId:J

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40460
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40461
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 40449
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40450
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetMessageFactCheck;->chatId:J

    .line 40451
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$SetMessageFactCheck;->messageId:J

    .line 40452
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$SetMessageFactCheck;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 40453
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40457
    const v0, -0x41c2f8

    return v0
.end method
