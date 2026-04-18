.class public Lorg/drinkless/tdlib/TdApi$ParseTextEntities;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ParseTextEntities"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$FormattedText;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x65e03d61


# instance fields
.field public parseMode:Lorg/drinkless/tdlib/TdApi$TextParseMode;

.field public text:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29184
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29185
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$TextParseMode;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "textParseMode"    # Lorg/drinkless/tdlib/TdApi$TextParseMode;

    .line 29174
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29175
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ParseTextEntities;->text:Ljava/lang/String;

    .line 29176
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ParseTextEntities;->parseMode:Lorg/drinkless/tdlib/TdApi$TextParseMode;

    .line 29177
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29181
    const v0, -0x65e03d61

    return v0
.end method
