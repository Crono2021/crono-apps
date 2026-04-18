.class public Lorg/drinkless/tdlib/TdApi$GetUserPrivacySettingRules;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetUserPrivacySettingRules"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$UserPrivacySettingRules;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7bcfe98f


# instance fields
.field public setting:Lorg/drinkless/tdlib/TdApi$UserPrivacySetting;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13920
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13921
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$UserPrivacySetting;)V
    .locals 0
    .param p1, "userPrivacySetting"    # Lorg/drinkless/tdlib/TdApi$UserPrivacySetting;

    .line 13911
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13912
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetUserPrivacySettingRules;->setting:Lorg/drinkless/tdlib/TdApi$UserPrivacySetting;

    .line 13913
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13917
    const v0, -0x7bcfe98f

    return v0
.end method
