.class public Lorg/drinkless/tdlib/TdApi$DeleteBusinessConnectedBot;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteBusinessConnectedBot"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x616481ab


# instance fields
.field public botUserId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11238
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11239
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 11229
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11230
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteBusinessConnectedBot;->botUserId:J

    .line 11231
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11235
    const v0, -0x616481ab

    return v0
.end method
