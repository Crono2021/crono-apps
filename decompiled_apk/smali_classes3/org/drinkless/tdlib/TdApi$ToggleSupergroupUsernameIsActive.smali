.class public Lorg/drinkless/tdlib/TdApi$ToggleSupergroupUsernameIsActive;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleSupergroupUsernameIsActive"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x59749201


# instance fields
.field public isActive:Z

.field public supergroupId:J

.field public username:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41274
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41275
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Z)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "z8"    # Z

    .line 41263
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41264
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleSupergroupUsernameIsActive;->supergroupId:J

    .line 41265
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleSupergroupUsernameIsActive;->username:Ljava/lang/String;

    .line 41266
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$ToggleSupergroupUsernameIsActive;->isActive:Z

    .line 41267
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41271
    const v0, -0x59749201

    return v0
.end method
