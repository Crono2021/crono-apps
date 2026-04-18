.class public Lorg/drinkless/tdlib/TdApi$GetLogStream;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetLogStream"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$LogStream;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x45984b5b


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 2449
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 2454
    const v0, 0x45984b5b

    return v0
.end method
