.class public Lorg/drinkless/tdlib/TdApi$GetBusinessConnectedBot;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetBusinessConnectedBot"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$BusinessConnectedBot;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x364da7c3


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 2229
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 2234
    const v0, 0x364da7c3

    return v0
.end method
