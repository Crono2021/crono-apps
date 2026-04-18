.class public Lorg/drinkless/tdlib/TdApi$GetJsonString;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetJsonString"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Text;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x278b9421


# instance fields
.field public jsonValue:Lorg/drinkless/tdlib/TdApi$JsonValue;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12984
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12985
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$JsonValue;)V
    .locals 0
    .param p1, "jsonValue"    # Lorg/drinkless/tdlib/TdApi$JsonValue;

    .line 12975
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12976
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetJsonString;->jsonValue:Lorg/drinkless/tdlib/TdApi$JsonValue;

    .line 12977
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12981
    const v0, 0x278b9421

    return v0
.end method
