.class public Lorg/drinkless/tdlib/TdApi$GetKeywordEmojis;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetKeywordEmojis"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Emojis;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7568b396


# instance fields
.field public inputLanguageCodes:[Ljava/lang/String;

.field public text:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26264
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26265
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "strArr"    # [Ljava/lang/String;

    .line 26254
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26255
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetKeywordEmojis;->text:Ljava/lang/String;

    .line 26256
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GetKeywordEmojis;->inputLanguageCodes:[Ljava/lang/String;

    .line 26257
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26261
    const v0, -0x7568b396

    return v0
.end method
