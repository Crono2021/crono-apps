.class public Lorg/drinkless/tdlib/TdApi$RemoveNotificationGroup;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RemoveNotificationGroup"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x661a638e


# instance fields
.field public maxNotificationId:I

.field public notificationGroupId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29948
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29949
    return-void
.end method

.method public constructor <init>(II)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I

    .line 29938
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29939
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$RemoveNotificationGroup;->notificationGroupId:I

    .line 29940
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$RemoveNotificationGroup;->maxNotificationId:I

    .line 29941
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29945
    const v0, 0x661a638e

    return v0
.end method
